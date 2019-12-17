# list-page
Java lib for chunking down a list. 

This might be crucial should you want to  chunk a list and return smaller bits to the application for processing. 
Take for instance the following : 

The developer of a read method for a batch job. The method is called repeatedly until all list items are processed; yet
the developer does not want all that data going for processing at once, rather one bit at a time. This is where the
list-page library comes in. Once instantiated, it will return chunks of the list sequentially until the list is 
exhausted at which point it will return an empty list

        @Override
        public List<EVM> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    
            ListEVM> returnListItems = listPage.getProcessingPage(unProcessedItems, processedItems);
    
            log.info("Returning processing list of size : {}", returnListItems.size());
    
            return returnListItems.size() == 0 ? null : returnListItems;
            
        }
        
The following is a typical workflow: 

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
         
## INSTALLATION

Add the jit-pack repository

        <repositories>
     		<repository>
     		    <id>jitpack.io</id>
     		    <url>https://jitpack.io</url>
     		</repository>
     	</repositories>
     	
The add the dependency

        <dependency>
            <groupId>com.github.ghacupha</groupId>
            <artifactId>list-page</artifactId>
            <version>-SNAPSHOT</version>
        </dependency>


LICENSE : [MIT](LICENSE)
