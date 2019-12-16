package io.github.ghacupha;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RuntimeListPage<T> extends ObjectListPage<T> implements IListPage<T>  {

    private static final List processedItems  = new ArrayList<>();

    public RuntimeListPage(final int pageSize) {
        super(pageSize);
    }

    /**
     * Call this opinionated method if you need a runtime processed-items-list
     *
     * @param unprocessedItems
     * @return
     */
    public List<T> getProcessingPage(final List<T> unprocessedItems) {

        List<T> returnList =  this.getProcessingPage(unprocessedItems, processedItems);

        // update processed items
        processedItems.addAll(returnList);

        return returnList;
    }
}
