package com.swordgroup.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WaterService {

    private JobLauncher jobLauncher;

    private Job flowJob;

    @Autowired
    public WaterService(JobLauncher jobLauncher, Job flowJob) {
        this.jobLauncher = jobLauncher;
        this.flowJob = flowJob;
    }


    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void run() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = new JobParametersBuilder().addDate("time", new Date()).toJobParameters();
        jobLauncher.run(flowJob, jobParameters);
    }
}
