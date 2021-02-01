package com.application.crater.dtos.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CreateProductRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Nome obrigatório")
	private String name;

	@NotEmpty(message = "Preço obrigatório")
	private Double price;

	private Integer quantity;

	private String category;

	public CreateProductRequest() {
	}

	public CreateProductRequest(String name, Double price, Integer quantity, String category) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
