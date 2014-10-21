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

import com.program.listener.StudentListener;
import com.program.model.Student;

@Component
public class NormalFlowScheduler {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job runJob;
	@Autowired
	private StudentListener studentListener;

	@Scheduled(cron = "0/5 * * * * *")
	public void invokeScheduler() {
		List<Student> students = new ArrayList<Student>();
		Student student1 = new Student("student1", 70);
		Student student2 = new Student("student2", 96);
		Student student3 = new Student("student3", 32);
		Student student4 = new Student("student4", 53);
		Student student5 = new Student("student5", 63);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);

		for (int i = 0; i < students.size(); i++) {
			studentListener.setStudent(students.get(i));
			JobParameters param = new JobParametersBuilder().addLong("time",
					System.currentTimeMillis()).toJobParameters();
			try {
				jobLauncher.run(runJob, param);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
}
