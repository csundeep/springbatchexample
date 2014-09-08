package com.program.model;

public class RefundDeta {
	private int id;
	private boolean isCustomerNoTax;
	private String pastFailure;
	private String presentFailure;

	public RefundDeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RefundDeta(int id, boolean isCustomerNoTax, String pastFailure,
			String presentFailure) {
		super();
		this.id = id;
		this.isCustomerNoTax = isCustomerNoTax;
		this.pastFailure = pastFailure;
		this.presentFailure = presentFailure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCustomerNoTax() {
		return isCustomerNoTax;
	}

	public void setCustomerNoTax(boolean isCustomerNoTax) {
		this.isCustomerNoTax = isCustomerNoTax;
	}

	public String getPastFailure() {
		return pastFailure;
	}

	public void setPastFailure(String pastFailure) {
		this.pastFailure = pastFailure;
	}

	public String getPresentFailure() {
		return presentFailure;
	}

	public void setPresentFailure(String presentFailure) {
		this.presentFailure = presentFailure;
	}

	@Override
	public String toString() {
		return "RefundData [id=" + id + ", isCustomerNoTax=" + isCustomerNoTax
				+ ", pastFailure=" + pastFailure + ", presentFailure="
				+ presentFailure + "]";
	}

}
