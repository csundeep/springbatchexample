package com.program.scheduler;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class GPRSScheduler {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job runJob;


	@Scheduled(cron = "0/5 * * * * *")
	public void invokeScheduler() {
		
		JobParameters param = new JobParametersBuilder().addLong("time",
				System.currentTimeMillis()).toJobParameters();
		try {
			jobLauncher.run(runJob, param);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
