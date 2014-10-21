package com.program.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;

import com.program.model.Student;

@Component
public class GradeDecider implements JobExecutionDecider {

	@Override
	public FlowExecutionStatus decide(JobExecution arg0, StepExecution arg1) {
		Student student = (Student) arg1.getExecutionContext().get("student");
		arg0.getExecutionContext().put("student", student);
		if (student.getMarks() > 90)
			return new FlowExecutionStatus("A");
		else if (student.getMarks() > 60)
			return new FlowExecutionStatus("B");
		else
			return new FlowExecutionStatus("C");

	}

}
