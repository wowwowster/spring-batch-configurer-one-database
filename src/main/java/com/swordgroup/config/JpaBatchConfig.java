package com.swordgroup.config;

import com.swordgroup.entity.db.JpaUser;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManagerFactory;


@Configuration
@Import({ApplicationDBConfig.class, /* BatchDBConfig.class , */ MyBatchConfigurer.class})
@EnableBatchProcessing
public class JpaBatchConfig  {

    @Autowired
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    private final JobBuilderFactory jobBuilderFactory;

    @Autowired
    @Qualifier("applicationEntityManagerFactory")
    private EntityManagerFactory applicationEntityManagerFactory;


    @Autowired
    public JpaBatchConfig(StepBuilderFactory stepBuilderFactory, JobBuilderFactory jobBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public ItemReader<JpaUser> jpaItemReader() {
        JpaPagingItemReader<JpaUser> itemReader = new JpaPagingItemReader<>();
        itemReader.setEntityManagerFactory(applicationEntityManagerFactory);
        itemReader.setQueryString("select u from JpaUser u");
        return itemReader;
    }

    @Bean
    public ItemProcessor<JpaUser, JpaUser> processor() {
        return item -> {
            item.setAge(item.getAge() + 1);
            item.setDescription("have deal");
            return item;
        };
    }

    @Bean
    public ItemWriter<JpaUser> jpaItemWriter() {
        JpaItemWriter<JpaUser> itemWriter = new JpaItemWriter<>();
        itemWriter.setEntityManagerFactory(applicationEntityManagerFactory);
        return itemWriter;
    }

    @Bean
    public Step step(ItemReader<JpaUser> jpaItemReader, ItemProcessor<JpaUser, JpaUser> processor,
                     ItemWriter<JpaUser> jpaItemWriter) {
        return stepBuilderFactory.get("addAge")
                .<JpaUser, JpaUser>chunk(2)
                .reader(jpaItemReader)
                .processor(processor)
                .writer(jpaItemWriter)
                .build();
    }

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory.get("addJob")
                .listener(new JobExecutionListener() {
                    private Long time;

                    @Override
                    public void beforeJob(JobExecution jobExecution) {
                        time = System.currentTimeMillis();
                    }

                    @Override
                    public void afterJob(JobExecution jobExecution) {
                        System.out.println(String.format("public Job job(Step step) : %sms", System.currentTimeMillis() - time));
                    }
                })
                .flow(step)
                .end()
                .build();
    }

    /* @Bean
    public BatchConfigurer configurer(){
        return new MyBatchConfigurer();
    } */




}
