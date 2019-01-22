package com.swordgroup.config;


//@Configuration
public class XmlBatchConfig {

   /* private final StepBuilderFactory stepBuilderFactory;

    private final JobBuilderFactory jobBuilderFactory;

    @Autowired
    public XmlBatchConfig(StepBuilderFactory stepBuilderFactory, JobBuilderFactory jobBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public XStreamMarshaller xStreamMarshaller() {
        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        xStreamMarshaller.setAnnotatedClasses(XmlUser.class);
        return xStreamMarshaller;
    }

    @Bean
    public ItemReader<XmlUser> xmlItemReader(XStreamMarshaller xStreamMarshaller) {
        return new StaxEventItemReaderBuilder<XmlUser>()
                .name("xmlItemReader")
                .resource(new ClassPathResource("before.xml"))
                .addFragmentRootElements("xml-user")
                .unmarshaller(xStreamMarshaller)
                .build();
    }

    @Bean
    public ItemWriter<XmlUser> xmlItemWriter(XStreamMarshaller xStreamMarshaller) {
        return new StaxEventItemWriterBuilder<XmlUser>()
                .name("xmlItemWriter")
                .resource(new ClassPathResource("after.xml"))
                .marshaller(xStreamMarshaller)
                .build();
    }

    @Bean
    public Step xmlStep(ItemReader<XmlUser> xmlItemReader,
                        ItemWriter<XmlUser> xmlItemWriter) {
        return stepBuilderFactory.get("xmlStep")
                .<XmlUser, XmlUser>chunk(5)
                .reader(xmlItemReader)
                .processor((ItemProcessor<XmlUser, XmlUser>) batchUser -> {
                    batchUser.setAge(batchUser.getAge() + 1);
                    batchUser.setDescription("已处理");
                    return batchUser;
                })
                .writer(xmlItemWriter)
                .build();
    }

    @Bean
    public Job xmlJob(Step xmlStep) {
        return jobBuilderFactory.get("xmlJob")
                .incrementer(new RunIdIncrementer())
                .start(xmlStep)
                .build();
    }
    */
}
