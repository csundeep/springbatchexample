package com.program.processor;

import java.io.Serializable;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.program.model.Student;

@Component
@Scope(value = "step")
public class AddIdProcessor implements ItemProcessor<Student, Student>,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	boolean lock = false;

	@Override
	public Student process(Student student) throws Exception {
		student.setId(35);
		if (!lock)
			System.out.println("In AddIdProcessor :" + threadName + " : "
					+ student);
		lock = true;
		return student;
	}

}
