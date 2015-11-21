package com.todo.services;

import java.util.List;

import com.todo.entity.Product;
/**
 * 
 * @author Vijayamurugan D
 *
 */
public interface ProductDataService {

	public List<Product> getAllData();

	public Product getProductById(String SKU);

	public List<Product> getProducts(List<String> SKU);
}
