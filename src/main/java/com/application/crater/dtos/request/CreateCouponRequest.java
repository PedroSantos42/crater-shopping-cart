package com.application.crater.dtos.request;

import java.io.Serializable;

public class CreateCouponRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double discount;

	private String occasion;

	public CreateCouponRequest() {
	}

	public CreateCouponRequest(Double discount, String occasion) {
		super();
		this.discount = discount;
		this.occasion = occasion;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
}
