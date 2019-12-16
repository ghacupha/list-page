package io.github.ghacupha;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ObjectListPageTest {

    private List<Indexable> processItems;
    private List<Name> processingNames;

    @BeforeEach
    void setUp() {
        processItems = ImmutableList.of(() -> 0, () -> 1, () -> 2, () -> 4, () -> 5, () -> 6, () -> 7, () -> 8, () -> 9, () -> 10, () -> 11, () -> 12, () -> 13, () -> 14);

        processingNames = ImmutableList.of(
            Name.builder().index(0).name("Haswell").build(),
            Name.builder().index(1).name("Bush").build(),
            Name.builder().index(2).name("Edwin").build(),
            Name.builder().index(3).name("Clinton").build(),
            Name.builder().index(4).name("Hillary").build(),
            Name.builder().index(5).name("Marx").build(),
            Name.builder().index(6).name("Wiggin").build(),
            Name.builder().index(7).name("Andrew").build(),
            Name.builder().index(8).name("Maxwell").build(),
            Name.builder().index(9).name("Graham").build(),
            Name.builder().index(10).name("Tesla").build(),
            Name.builder().index(11).name("Nicola").build(),
            Name.builder().index(12).name("Dickson").build(),
            Name.builder().index(13).name("Obama").build(),
            Name.builder().index(14).name("Walker").build(),
            Name.builder().index(15).name("Matthias").build(),
            Name.builder().index(16).name("Elias").build(),
            Name.builder().index(17).name("Dorcas").build()
        );
    }

    @Test
    void getOpinionatedProcessingPageFromCustomObjects() {

        IListPage<Name> listPage = new ObjectListPage<Name>(5);

        List<Name> page1 = listPage.getProcessingPage(processingNames);
        int PAGE_1_SIZE = page1.size();

        List<Name> page2 = listPage.getProcessingPage(processingNames);
        int PAGE_2_SIZE = page2.size();

        List<Name> page3 = listPage.getProcessingPage(processingNames);
        int PAGE_3_SIZE = page3.size();

        List<Name> page4 = listPage.getProcessingPage(processingNames);
        int PAGE_4_SIZE = page4.size();

        List<Name> page5 = listPage.getProcessingPage(processingNames);
        int PAGE_5_SIZE = page5.size();

        List<Name> page6 = listPage.getProcessingPage(processingNames);
        int PAGE_6_SIZE = page6.size();

        List<Name> page7 = listPage.getProcessingPage(processingNames);
        int PAGE_7_SIZE = page7.size();

        List<Name> page8 = listPage.getProcessingPage(processingNames);
        int PAGE_8_SIZE = page8.size();

        assertThat(PAGE_1_SIZE).isEqualTo(5);
        assertThat(PAGE_2_SIZE).isEqualTo(5);
        assertThat(PAGE_3_SIZE).isEqualTo(5);
        assertThat(PAGE_4_SIZE).isEqualTo(3);
        assertThat(PAGE_5_SIZE).isEqualTo(0);
        assertThat(PAGE_6_SIZE).isEqualTo(0);
        assertThat(PAGE_7_SIZE).isEqualTo(0);
        assertThat(PAGE_8_SIZE).isEqualTo(0);
    }

    @Test
    void getProcessingPageFromCustomObjects() {

        IListPage<Name> listPage = new ObjectListPage<Name>(5);
        int PROCESSED_ITEMS = processingNames.size();

        List<Name> processedNames = new ArrayList<>();

        List<Name> page1 = listPage.getProcessingPage(processingNames, processedNames);
        processedNames.addAll(page1);
        int PAGE_1_SIZE = page1.size();

        assertThat(processedNames.size()).isEqualTo(5);

        List<Name> page2 = listPage.getProcessingPage(processingNames, processedNames);
        processedNames.addAll(page2);
        int PAGE_2_SIZE = page2.size();

        assertThat(processedNames.size()).isEqualTo(10);

        List<Name> page3 = listPage.getProcessingPage(processingNames, processedNames);
        processedNames.addAll(page3);
        int PAGE_3_SIZE = page3.size();

        assertThat(processedNames.size()).isEqualTo(15);

        List<Name> page4 = listPage.getProcessingPage(processingNames, processedNames);
        processedNames.addAll(page4);
        int PAGE_4_SIZE = page4.size();

        assertThat(processedNames.size()).isEqualTo(18);

        List<Name> page5 = listPage.getProcessingPage(processingNames, processedNames);
        processedNames.addAll(page5);
        int PAGE_5_SIZE = page5.size();

        assertThat(processedNames.size()).isEqualTo(18);

        List<Name> page6 = listPage.getProcessingPage(processingNames, processedNames);
        processedNames.addAll(page6);
        int PAGE_6_SIZE = page6.size();

        assertThat(processedNames.size()).isEqualTo(18);

        List<Name> page7 = listPage.getProcessingPage(processingNames, processedNames);
        processedNames.addAll(page7);
        int PAGE_7_SIZE = page7.size();

        assertThat(processedNames.size()).isEqualTo(18);

        List<Name> page8 = listPage.getProcessingPage(processingNames, processedNames);
        processedNames.addAll(page8);
        int PAGE_8_SIZE = page8.size();

        assertThat(processedNames.size()).isEqualTo(18);

        assertThat(PAGE_1_SIZE).isEqualTo(5);
        assertThat(PAGE_2_SIZE).isEqualTo(5);
        assertThat(PAGE_3_SIZE).isEqualTo(5);
        assertThat(PAGE_4_SIZE).isEqualTo(3);
        assertThat(PAGE_5_SIZE).isEqualTo(0);
        assertThat(PAGE_6_SIZE).isEqualTo(0);
        assertThat(PAGE_7_SIZE).isEqualTo(0);
        assertThat(PAGE_8_SIZE).isEqualTo(0);
        assertThat(processedNames.size()).isEqualTo(PROCESSED_ITEMS);
    }

    @Test
    void getProcessingPage() {

        IListPage<Indexable> listPage = new ObjectListPage<>(4);
        int PROCESSED_ITEMS = processItems.size();

        List<Indexable> processedItemsIndices = new ArrayList<>();

        List<Indexable> page1 = listPage.getProcessingPage(processItems, processedItemsIndices);
        processedItemsIndices.addAll(page1);
        int PAGE_1_SIZE = page1.size();

        assertThat(processedItemsIndices.size()).isEqualTo(4);

        List<Indexable> page2 = listPage.getProcessingPage(processItems, processedItemsIndices);
        processedItemsIndices.addAll(page2);
        int PAGE_2_SIZE = page2.size();

        assertThat(processedItemsIndices.size()).isEqualTo(8);

        List<Indexable> page3 = listPage.getProcessingPage(processItems, processedItemsIndices);
        processedItemsIndices.addAll(page3);
        int PAGE_3_SIZE = page3.size();

        assertThat(processedItemsIndices.size()).isEqualTo(12);

        List<Indexable> page4 = listPage.getProcessingPage(processItems, processedItemsIndices);
        processedItemsIndices.addAll(page4);
        int PAGE_4_SIZE = page4.size();

        assertThat(processedItemsIndices.size()).isEqualTo(14);

        List<Indexable> page5 = listPage.getProcessingPage(processItems, processedItemsIndices);
        processedItemsIndices.addAll(page5);
        int PAGE_5_SIZE = page5.size();

        assertThat(processedItemsIndices.size()).isEqualTo(14);

        List<Indexable> page6 = listPage.getProcessingPage(processItems, processedItemsIndices);
        processedItemsIndices.addAll(page6);
        int PAGE_6_SIZE = page6.size();

        assertThat(processedItemsIndices.size()).isEqualTo(14);

        List<Indexable> page7 = listPage.getProcessingPage(processItems, processedItemsIndices);
        processedItemsIndices.addAll(page7);
        int PAGE_7_SIZE = page7.size();

        assertThat(processedItemsIndices.size()).isEqualTo(14);

        List<Indexable> page8 = listPage.getProcessingPage(processItems, processedItemsIndices);
        processedItemsIndices.addAll(page8);
        int PAGE_8_SIZE = page8.size();

        assertThat(processedItemsIndices.size()).isEqualTo(14);

        assertThat(PAGE_1_SIZE).isEqualTo(4);
        assertThat(PAGE_2_SIZE).isEqualTo(4);
        assertThat(PAGE_3_SIZE).isEqualTo(4);
        assertThat(PAGE_4_SIZE).isEqualTo(2);
        assertThat(PAGE_5_SIZE).isEqualTo(0);
        assertThat(PAGE_6_SIZE).isEqualTo(0);
        assertThat(PAGE_7_SIZE).isEqualTo(0);
        assertThat(PAGE_8_SIZE).isEqualTo(0);
        assertThat(processedItemsIndices.size()).isEqualTo(PROCESSED_ITEMS);
    }
}
