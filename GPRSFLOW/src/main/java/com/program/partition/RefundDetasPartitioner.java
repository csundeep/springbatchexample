package com.program.partition;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

@Component
public class RefundDetasPartitioner implements
		org.springframework.batch.core.partition.support.Partitioner {

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {

		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

		for (int i = 1; i <= gridSize; i++) {
			ExecutionContext executionContext = new ExecutionContext();
			executionContext.putString("name", "Thread" + i);
			result.put("partition" + i, executionContext);

		}

		return result;
	}
}
