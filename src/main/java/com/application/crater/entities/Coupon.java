package com.application.crater.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double discount;

    private String occasion;
    
    public Coupon() {}

	public Coupon(Integer id, Double discount, String occasion) {
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
