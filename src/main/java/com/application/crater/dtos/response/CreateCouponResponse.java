package com.application.crater.dtos.response;

import java.io.Serializable;

public class CreateCouponResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Double discount;

	private String occasion;

	public CreateCouponResponse() {
	}

	public CreateCouponResponse(Integer id, Double discount, String occasion) {
		super();
		this.id = id;
		this.discount = discount;
		this.occasion = occasion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
