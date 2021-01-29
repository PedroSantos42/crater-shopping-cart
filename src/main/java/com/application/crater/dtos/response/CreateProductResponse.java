package com.application.crater.dtos.response;

import java.io.Serializable;

public class CreateProductResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Double price;

	private Integer quantity;

	public CreateProductResponse() {
	}

	public CreateProductResponse(Integer id, String name, Double price, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
