package com.program.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class TestDecider implements JobExecutionDecider {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public FlowExecutionStatus decide(JobExecution arg0, StepExecution arg1) {
		if (value.equals("two"))
			return new FlowExecutionStatus("two");
		else
			return new FlowExecutionStatus("three");

	}

}
