package com.todo.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.todo.config.ServiceConfig;
import com.todo.entity.Product;
import com.todo.entity.ProductType;
import com.todo.services.ProductDataService;

/**
 * Product Data Spooling unit test cases
 * @author Vijayamurugan D
 *
 */

public class ProductDataImplTest {

	ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceConfig.class);
	ProductDataService pds = (ProductDataService) context
			.getBean(ProductDataService.class);

	@Test
	public void getAllProductDataTest() {

		Assert.assertNotNull(pds);
		List<Product> allProducts = pds.getAllData();

		Assert.assertNotNull(allProducts);

		Product prod = allProducts.get(0);

		String name = null;

		String SKU = null;

		ProductType productType = null;

		BigDecimal price = BigDecimal.ZERO;

		String description = null;

		String UOM = null;

		Assert.assertNotSame(name, prod.getName());
		Assert.assertNotSame(SKU, prod.getSKU());
		Assert.assertNotSame(productType, prod.getProductType());
		Assert.assertNotSame(description, prod.getDescription());
		Assert.assertNotSame(UOM, prod.getUOM());
		Assert.assertNotSame(price, prod.getPrice());
		Assert.assertNotNull(prod.getName());
		Assert.assertNotNull(prod.getPrice());
		Assert.assertNotNull(prod.getProductType());
	}

	@Test
	public void getProductById() {

		Product prod = pds.getProductById("101");
		Assert.assertNotNull(prod.getName());
		Assert.assertNotNull(prod.getPrice());
		Assert.assertNotNull(prod.getProductType());

	}

	@Test
	public void getProductsbySKUS() {

		List<String> skuList = new ArrayList<String>();
		skuList.add("101");
		skuList.add("102");

		List<Product> prods = pds.getProducts(skuList);
		Assert.assertNotNull(prods);
		for (Product prod : prods) {
			Assert.assertNotNull(prod.getName());
			Assert.assertNotNull(prod.getPrice());
			Assert.assertNotNull(prod.getProductType());
		}

	}
}
