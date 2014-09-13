package com.program.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.program.model.Student;

@Component
public class AddNameProcessor implements ItemProcessor<Student, Student> {

	@Override
	public Student process(Student student) throws Exception {
		student.setName("sandy"+(int) Math.random()*100);
		System.out.println("In AddNameProcessor"+student);
		return student;
	}

}
