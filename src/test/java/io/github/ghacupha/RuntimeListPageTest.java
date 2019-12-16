package io.github.ghacupha;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RuntimeListPageTest {


    private List<Name> processingNames;

    @BeforeEach
    void setUp() {
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

    /**
     * This test shows the persistence of the processed-items-list across
     * all list-page objects
     */
    @Test
    void getOpinionatedProcessingPageFromCustomObjects() {

        IListPage<Name> listPage = new RuntimeListPage<Name>(5);

        List<Name> page1 = listPage.getProcessingPage(processingNames);
        int PAGE_1_SIZE = page1.size();

        List<Name> page2 = listPage.getProcessingPage(processingNames);
        int PAGE_2_SIZE = page2.size();

        // ! Application creates a new list-page instance with 2 items
        IListPage<Name> listPage2 = new RuntimeListPage<Name>(2);
        List<Name> page3 = listPage2.getProcessingPage(processingNames);
        int PAGE_3_SIZE = page3.size();

        List<Name> page4 = listPage2.getProcessingPage(processingNames);
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
        assertThat(PAGE_3_SIZE).isEqualTo(2);
        assertThat(PAGE_4_SIZE).isEqualTo(2);
        assertThat(PAGE_5_SIZE).isEqualTo(4);
        assertThat(PAGE_6_SIZE).isEqualTo(0);
        assertThat(PAGE_7_SIZE).isEqualTo(0);
        assertThat(PAGE_8_SIZE).isEqualTo(0);
    }
}
