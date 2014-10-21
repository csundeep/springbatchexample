package com.program.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.program.model.Student;

@Component
public class ReadStudent implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		Student student = (Student) arg1.getStepContext().getStepExecution()
				.getExecutionContext().get("student");
		System.out.println("Read Student " + student);
		return RepeatStatus.FINISHED;
	}
}
