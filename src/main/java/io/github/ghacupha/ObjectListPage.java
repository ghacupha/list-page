package io.github.ghacupha;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

// @formatter:off
/**
 * This home made paging algorithm helps the reader page chunks of information from a bigger list by
 * maintaining an index of unprocessed items until when the list provided is less than the page size.
 * It is expected a faithful client will maintain a list of items which have already been processed.
 * The client also needs to check if the list returned has 0 items meaning the processing items are
 * exhausted. Once the list is exhausted continued calls will yield empty lists.
 *
 * Calling the function without processing items takes on an opinionated server-knows-all approach
 * as it the object maintains its own internal list of processed items.
 * If a new object is creates the list of processed items is refreshed and will start afresh.
 *
 * If a list of processed items needs to be preserved through out application runtime, once could
 * create singleton and use it for processed list with the un-opinionated method or use the RuntimeListPage
 */
// @formatter:on
@Slf4j
public class ObjectListPage<T> implements IListPage<T> {

    private final int pageSize;
    private final List<T> processedItems;

    public ObjectListPage(final int pageSize) {
        this.pageSize = pageSize;
        processedItems = new ArrayList<>();
    }

    public List<T> getProcessingPage(final List<T> unprocessedItems) {

        List<T> returnList =  getProcessingPage(unprocessedItems, processedItems);

        // update processed items
        processedItems.addAll(returnList);

        return returnList;
    }

    public List<T> getProcessingPage(final List<T> unprocessedItems, final List<T> processedItems) {
        return getProcessingPage(unprocessedItems.stream().filter(item -> !processedItems.contains(item)).collect(ImmutableList.toImmutableList()), this.pageSize);
    }


    /**
     *
     * @param unprocessedItems List containing a list of unprocessed items
     * @param pageSize The number of items expected in the list
     * @return
     */
    private List<T> getProcessingPage(List<T> unprocessedItems, int pageSize) {

        log.debug("Processing {} items", unprocessedItems.size());
        List<T> processingPage = new ArrayList<>();

        if (unprocessedItems.size() > pageSize) {

            int i = 0;

            while (i < pageSize) {
                processingPage.add(unprocessedItems.get(++i));
            }
        }
        if (unprocessedItems.size() < pageSize) {
            log.debug("Process list requested a page of {} items which is less than the configured page of {}", unprocessedItems.size(), pageSize);
            log.debug("Adding everything to list...");
            processingPage.addAll(unprocessedItems);
        }

        return ImmutableList.copyOf(processingPage);
    }
}
