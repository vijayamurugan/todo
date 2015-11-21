package com.todo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.entity.Product;
import com.todo.entity.ProductType;
/**
 * Product data Simulation it can be later mapped to the storage
 * @author Vijayamurugan D
 * 
 *
 */
@Service
public class ProductDataImpl implements ProductDataService {

	@Override
	public List<Product> getAllData() {
		List<Product> result = new ArrayList<Product>();

		Product prod = new Product();
		prod.setName("Rice");
		prod.setPrice(new BigDecimal(40));
		prod.setUOM("Kilogram");
		prod.setProductType(ProductType.GROCERRIES);
		prod.setDescription("");
		prod.setSKU("101");
		result.add(prod);

		Product prod1 = new Product();
		prod1.setName("Wheat");
		prod1.setPrice(new BigDecimal(45));
		prod1.setUOM("Kilogram");
		prod1.setProductType(ProductType.GROCERRIES);
		prod1.setSKU("102");
		prod.setDescription("");
		result.add(prod1);

		Product prod2 = new Product();
		prod2.setName("Apple 6s");
		prod2.setPrice(new BigDecimal(72000));
		prod2.setUOM("Piece");
		prod2.setProductType(ProductType.ELECTRONICS);
		prod2.setSKU("103");
		prod.setDescription("");
		result.add(prod2);

		Product prod3 = new Product();
		prod3.setName("Levis Jeans");
		prod3.setPrice(new BigDecimal(3500));
		prod3.setUOM("Piece");
		prod3.setProductType(ProductType.APPARELS);
		prod3.setSKU("104");
		prod.setDescription("");
		result.add(prod3);

		Product prod4 = new Product();
		prod4.setName("Western Digital Hard Disk 1TB");
		prod4.setPrice(new BigDecimal(6700));
		prod4.setUOM("Piece");
		prod4.setProductType(ProductType.ELECTRONICS);
		prod4.setSKU("105");
		result.add(prod4);

		return result;
	}

	public Product getProductById(String SKU) {
		Product product = null;
		for (Product prod : getAllData()) {
			if (prod.getSKU().equals(SKU)) {
				product = prod;
				break;
			}

		}

		return product;

	}

	public List<Product> getProducts(List<String> SKU) {
		List<Product> result = new ArrayList<Product>();
		List<Product> products = getAllData();
		for (Product prod : products) {
			for (String sku : SKU) {
				if (prod.getSKU().equals(sku)) {
					result.add(prod);
					break;
				}
			}
		}

		return result;

	}
}
