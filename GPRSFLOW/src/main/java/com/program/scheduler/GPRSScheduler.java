package com.program.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.program.model.RefundDeta;
import com.program.reader.CalculatePositiveTaxReader;

@Component
public class GPRSScheduler {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job runJob;
	@Autowired
	private CalculatePositiveTaxReader calculatePositiveTaxReader;

	@Scheduled(cron = "0/5 * * * * *")
	public void invokeScheduler() {
		List<RefundDeta> refundDetas = new ArrayList<RefundDeta>();
		RefundDeta refundDeta;
		for (int i = 0; i < 50; i++) {
			if (i <= 9)
				refundDeta = new RefundDeta((i+1), false, null, null);//Normal Flow or past Calculate positive tax failure
			else if (i<=19) {
				refundDeta=new RefundDeta((i+1), false, "CNTF", null);// past Calculate Negative tax failure
			}
			else if (i<=29) {
				refundDeta=new RefundDeta((i+1), false, "COPTF", null);// past complete positive tax failure
			}
			else if (i<39) {
				refundDeta=new RefundDeta((i+1), false, "CONTF", null);// past complete Negative tax failure
			}
			else {
				refundDeta=new RefundDeta((i+1), true, null, null);// customer no tax
			}
			refundDetas.add(refundDeta);
		}
		calculatePositiveTaxReader.setRefundDetas(refundDetas);
		JobParameters param = new JobParametersBuilder().addLong("time",
				System.currentTimeMillis()).toJobParameters();
		try {
			jobLauncher.run(runJob, param);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
