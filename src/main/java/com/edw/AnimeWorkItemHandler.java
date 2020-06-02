package com.edw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.drools.core.process.instance.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

/**
 * <pre>
 *     com.edw.AnimeWorkItemHandler
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 02 Jun 2020 18:05
 */
public class AnimeWorkItemHandler implements WorkItemHandler {
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {
        wim.abortWorkItem(wi.getId());
    }

    // will try fire to https://jikan.moe/ api
    public void executeWorkItem(WorkItem wi, WorkItemManager wim) {
        String name = (String) wi.getParameter("name");

        String nameResponse = "";
        String imageUrl = "";

        try {
            // api endpoint = https://api.jikan.moe/v3/search/character?q=???&limit=1
            URL url = new URL(String.format("https://api.jikan.moe/v3/search/character?q=%s&limit=1", name));

            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            urlConnection.getInputStream()));
            String inputLine;
            StringBuffer stringBuffer = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            HashMap jsonResult = objectMapper.readValue(stringBuffer.toString(), HashMap.class);
            List<HashMap> results = (List<HashMap>) jsonResult.get("results");

            nameResponse = (String) results.get(0).get("name");
            imageUrl = (String) results.get(0).get("image_url");

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap result = new HashMap();
        result.put("nameResponse", nameResponse);
        result.put("imageUrl", imageUrl);
        wim.completeWorkItem(wi.getId(), result);
    }
}
