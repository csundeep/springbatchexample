package com.program.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.program.model.RefundDeta;
import com.program.reader.CompletePositiveTaxReader;

@Component
public class CaptureRefundWriter implements ItemWriter<RefundDeta> {
	@Autowired
	private CompletePositiveTaxReader completePositiveTaxReader;

	@Override
	public void write(List<? extends RefundDeta> refundDatas) throws Exception {
		for (RefundDeta refundData : refundDatas) {
			completePositiveTaxReader.getRefundDetas().add(refundData);
		}

	}

}
