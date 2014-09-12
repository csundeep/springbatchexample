package com.program.scheduler;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldScheduler {
	//private Student student;
	@Autowired private ApplicationContext applicationContext;

	public HelloWorldScheduler() {
		System.out.println("Starting Scheduler..........");
	}

	@Scheduled(cron = "0/5 * * * * ?")
	public void process() {
		for (int i = 0; i <2; i++) {
			Student student = getStudent();
			System.out.println(student.getAddress());
		}
	}
	
	
	public Student getStudent() {
		return (Student) applicationContext.getBean("student");
	}
}
