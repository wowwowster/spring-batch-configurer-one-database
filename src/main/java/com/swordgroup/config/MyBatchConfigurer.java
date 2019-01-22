package com.swordgroup.config;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//@Import({BatchDBConfig.class})
//@Import({ApplicationDBConfig.class, BatchDBConfig.class})
public class MyBatchConfigurer implements BatchConfigurer {


    @Autowired
    private DataSource applicationDataSource;

    @Autowired
    private PlatformTransactionManager applicationTransactionManager;

    @Override
    public JobRepository getJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(applicationDataSource);
        factory.setTransactionManager(getTransactionManager());
        factory.afterPropertiesSet();
        return  (JobRepository) factory.getObject();
    }

    @Override
    public PlatformTransactionManager getTransactionManager() throws Exception {
        //return new DataSourceTransactionManager(applicationDataSource);
        return applicationTransactionManager;
    }

    @Override
    public JobLauncher getJobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(getJobRepository());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

    @Override
    public JobExplorer getJobExplorer() throws Exception {
        return null;
    }
}
