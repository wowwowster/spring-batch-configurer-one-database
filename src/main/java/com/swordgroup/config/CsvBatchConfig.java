package com.swordgroup.config;

//@Configuration
public class CsvBatchConfig {

   /* private final DataSource dataSource;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public CsvBatchConfig(@Qualifier("dataSource") DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.dataSource = dataSource;
        this.transactionManager = transactionManager;
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType(DatabaseType.MYSQL.getProductName());
        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        return jobLauncher;
    }

    @Bean
    public ItemReader<CsvUser> csvItemReader() {
        return new FlatFileItemReader<CsvUser>() {{
            setResource(new ClassPathResource("before.csv"));
            // 用于设置文件与对象的映射关系
            setLineMapper(new DefaultLineMapper<CsvUser>() {{
                setLineTokenizer(new DelimitedLineTokenizer() {{
                    setNames("name", "age");
                }});
                setFieldSetMapper(new BeanWrapperFieldSetMapper<CsvUser>() {{
                    setTargetType(CsvUser.class);
                }});
            }});
        }};
    }

    @Bean
    public ItemWriter<CsvUser> csvItemWriter() {
        // 默认会清空文件重新编写，如需追加请指定append为true
        return new FlatFileItemWriterBuilder<CsvUser>()
                .name("writer")
                .resource(new ClassPathResource("after.csv"))
                .lineAggregator(new DelimitedLineAggregator<CsvUser>() {{
                    setFieldExtractor(new BeanWrapperFieldExtractor<CsvUser>() {{
                        setNames(new String[]{"name", "age"});
                    }});
                }}).build();
    }

    @Bean
    public Step csvStep(JobRepository jobRepository,
                        ItemReader<CsvUser> csvItemReader, ItemWriter<CsvUser> csvItemWriter) {
        return new StepBuilderFactory(jobRepository, transactionManager).get("csvStep")
                .<CsvUser, CsvUser>chunk(5)
                .reader(csvItemReader)
                .processor((ItemProcessor<CsvUser, CsvUser>) batchUser -> {
                    batchUser.setAge(batchUser.getAge() + 1);
                    return batchUser;
                })
                .writer(csvItemWriter)
                .build();
    }

    @Bean
    public Job csvJob(JobRepository jobRepository, Step csvStep) {
        return new JobBuilderFactory(jobRepository).get("csvJob")
                .incrementer(new RunIdIncrementer())
                .start(csvStep)
                .build();
    }*/
}