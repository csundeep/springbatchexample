package com.program.tasklets;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.program.model.Student;

@Component
public class StudentResult implements Tasklet {
	static List<Student> students = new ArrayList<Student>();

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		System.out.println("Student Result");

		Student student = (Student) arg1.getStepContext().getStepExecution()
				.getJobExecution().getExecutionContext().get("student");
		students.add(student);
		for (Student s : students) {
			System.out.println(s);
		}
		return RepeatStatus.FINISHED;
	}

}
