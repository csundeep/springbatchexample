package com.program.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.program.model.RefundDeta;

@Component
@Scope(value = "step")
public class CalculateNegativeTaxProcessor implements
		ItemProcessor<RefundDeta, RefundDeta> {
	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	int count = 0;

	@Override
	public RefundDeta process(RefundDeta refundDeta) throws Exception {
		if(refundDeta.getPastFailure()=="CNTF"&&!refundDeta.isCustomerNoTax()&&refundDeta.getPresentFailure()==null)
		System.out.println("In Calculate -ve Tax processor :" + threadName
				+ " : " + refundDeta + " iteration " + count++);
		if(refundDeta.getId()==13)
		{
			return null;
		}
		else
		return refundDeta;
	}

}
