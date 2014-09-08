package com.program.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.program.model.RefundDeta;
import com.program.reader.CaptureRefundReader;

@Component
public class CalculateNegativeTaxWriter implements ItemWriter<RefundDeta> {
	@Autowired
	private CaptureRefundReader captureRefundReader;

	@Override
	public void write(List<? extends RefundDeta> refundDetas) throws Exception {
		for (RefundDeta refundDeta : refundDetas) {
			captureRefundReader.getRefundDetas().add(refundDeta);
		}

	}

}
