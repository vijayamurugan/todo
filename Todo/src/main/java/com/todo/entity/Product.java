package com.todo.entity;

import java.math.BigDecimal;
/**
 * Product Entity
 * @author Vijayamurugan D
 *
 */
public class Product {

	private String name;
	
	private String SKU;

	private ProductType productType;

	private BigDecimal price;

	private String description;
	
	private String UOM;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}
	

}
