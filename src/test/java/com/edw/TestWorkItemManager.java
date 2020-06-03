package com.edw;

import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.WorkItemHandler;
import org.drools.core.process.instance.WorkItemManager;
import org.drools.core.process.instance.impl.WorkItemImpl;

import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *     com.edw.TestWorkItemManager
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 03 Jun 2020 17:44
 */
public class TestWorkItemManager implements WorkItemManager {

    private WorkItem workItem;

    @Override
    public void internalExecuteWorkItem(WorkItem workItem) {

    }

    @Override
    public void internalAddWorkItem(WorkItem workItem) {

    }

    @Override
    public void internalAbortWorkItem(long l) {

    }

    @Override
    public Set<WorkItem> getWorkItems() {
        return null;
    }

    @Override
    public WorkItem getWorkItem(long l) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void signalEvent(String s, Object o) {

    }

    @Override
    public void signalEvent(String s, Object o, long l) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void retryWorkItem(Long aLong, Map<String, Object> map) {

    }

    @Override
    public void registerWorkItemHandler(String s, org.kie.api.runtime.process.WorkItemHandler workItemHandler) {

    }

    TestWorkItemManager(WorkItem workItem) {
        this.workItem = workItem;
    }

    public void completeWorkItem(long id, Map<String, Object> results) {
        ((WorkItemImpl) workItem).setResults(results);

    }

    public void abortWorkItem(long id) {

    }

    public void registerWorkItemHandler(String workItemName,
                                        WorkItemHandler handler) {

    }
}