package com.program.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.program.model.RefundDeta;

@Component
public class AuditManagerWriter implements ItemWriter<RefundDeta>{

	@Override
	public void write(List<? extends RefundDeta> refundDatas) throws Exception {
		// for (RefundDeta refundData : refundDatas) {
		// System.out.println(refundData);
		// }
		
	}

}
