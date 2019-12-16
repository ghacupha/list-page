package io.github.ghacupha;

import java.util.List;

/**
 * This is an algorithm for chucking subsequent calls to an unprocessed list into smaller bits
 *
 * @param <T>
 */
public interface IListPage<T> {

    List<T> getProcessingPage(final List<T> unprocessedItems);

    List<T> getProcessingPage(List<T> unprocessedItems, List<T> processedItemsIndices);
}
