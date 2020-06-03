package com.edw;

import org.drools.core.process.instance.impl.WorkItemImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 *     com.edw.AnimeWorkItemHandlerTest
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 03 Jun 2020 17:40
 */
public class AnimeWorkItemHandlerTest {

    private AnimeWorkItemHandler animeWorkItemHandler;

    @Before
    public void init() {
        animeWorkItemHandler = new AnimeWorkItemHandler();
    }

    @Test
    public void testResponse() {
        WorkItemImpl workItem = new WorkItemImpl();
        workItem.setParameter("name", "naruto");
        animeWorkItemHandler.executeWorkItem(workItem, new TestWorkItemManager(workItem));
        Assert.assertEquals("Uzumaki, Naruto",
                (String) workItem.getResult("nameResponse"));
        Assert.assertEquals("https://cdn.myanimelist.net/images/characters/2/284121.jpg?s=3ebac88ad166bf105d8f04894f3fb469",
                (String) workItem.getResult("imageUrl"));
    }
}
