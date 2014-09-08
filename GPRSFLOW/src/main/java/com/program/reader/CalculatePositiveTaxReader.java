package com.program.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;
import com.program.model.RefundDeta;

@Component
public class CalculatePositiveTaxReader implements ItemReader<RefundDeta> {
	private List<RefundDeta> refundDetas=new ArrayList<RefundDeta>();

	public List<RefundDeta> getRefundDetas() {
		return refundDetas;
	}

	public void setRefundDetas(List<RefundDeta> refundDetas) {
		this.refundDetas = refundDetas;
	}

	@Override
	public RefundDeta read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		if (refundDetas.size() > 0) {
			return refundDetas.remove(0);
		} else
			return null;
	}
}
