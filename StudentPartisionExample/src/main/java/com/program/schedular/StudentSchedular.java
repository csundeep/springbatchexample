package com.program.schedular;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.stereotype.Component;

import com.program.model.Student;
import com.program.reader.StudentReader;

@Component
public class StudentSchedular {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job runJob;
	@Autowired
	private StudentReader studentReader;

	@Scheduled(cron = "0/5 * * * * *")
	public void invokeScheduler() {
		List<Student> students = new ArrayList<Student>();
		System.out.println("Schedular started");
		Student student1 = new Student(1, "sandy");
		Student student2 = new Student(2, "kiran");
		Student student3 = new Student(3, "Baru");
		students.add(student1);
		students.add(student2);
		students.add(student3);
		studentReader.setStudents(students);

		JobParameters param = new JobParametersBuilder().addLong("time",
				System.currentTimeMillis()).toJobParameters();
		try {
			jobLauncher.run(runJob, param);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}
