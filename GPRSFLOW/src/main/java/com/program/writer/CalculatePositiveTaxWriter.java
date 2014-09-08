package com.program.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.program.model.RefundDeta;
import com.program.reader.CalculateNegativeTaxReader;

@Component
public class CalculatePositiveTaxWriter implements ItemWriter<RefundDeta>{
@Autowired
private CalculateNegativeTaxReader calculateNegativeTaxReader;
	@Override
	public void write(List<? extends RefundDeta> refundDetas) throws Exception {
		for (RefundDeta refundDeta : refundDetas) {
			calculateNegativeTaxReader.getRefundDetas().add(refundDeta);
		}
		
	}

}
