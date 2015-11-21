package com.todo.test;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.todo.config.ServiceConfig;
import com.todo.services.InvoiceService;
import com.todo.view.InvoiceData;


/**
 * Invoice Service Unit test with possible test cases
 * @author Vijayamurugan D
 *
 */
public class InvoiceServiceTest {

	ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceConfig.class);
	InvoiceService invService = (InvoiceService) context
			.getBean(InvoiceService.class);

	@Test
	public void invoiceTest() {

		// Possible Test Cases

		/*
		 * 2 years customer with Groceries
		 * 
		 * 2 years customer without Groceries
		 * 
		 * Employee With Groceries
		 * 
		 * Affiliate With Groceries
		 * 
		 * Customer less than 2 years
		 * 
		 * Employee Without Groceries
		 * 
		 * Affiliate with Groceries Total amount below 100
		 * 
		 * 2 year member Plus Employee
		 */

		// Case 1: 2 years customer with Groceries
		// User =100/Vijay
		// UserType= customer
		// 2 Year member
		// Purchasing Items (2)
		// 1
		// Name Wheat
		// Price 45
		// Type:Grocerries
		// Qty 2 kgs
		// 2
		// Name Western Digital Hard Disk 1TB
		// Price 6700
		// Type: Electronics
		// Qty 2 items

		// Expected Result
		// He has to get 5 % discounts since he is member for two years
		// He should not get discount on groceries
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 45*2= 90
		// 6700*2 =13400
		// Discount on percentage only for ELECTRONICS=670
		// Discount on every 100 =670
		// Hence
		// Total Amount =13490
		// Discount Amount=1340
		// Net Payable=12150
		HashMap<String, Integer> items = new HashMap<String, Integer>();
		items.put("102", 2);
		items.put("105", 2);

		InvoiceData data = invService.generateInvoice(100, items);
		Assert.assertEquals(0,
				data.getTotalAmt().compareTo(new BigDecimal(13490)));
		Assert.assertEquals(0,
				data.getTotalDiscount().compareTo(new BigDecimal(1340)));
		Assert.assertEquals(0,
				data.getNetPayable().compareTo(new BigDecimal(12150)));

		// Case 2: 2 years customer without Groceries
		// User =100/Vijay
		// UserType= Customer
		// 2 Year member
		// Purchasing Items (2)
		// 1
		// Name Western Digital Hard Disk 1TB
		// Price 6700
		// Type: Electronics
		// Qty 2 items

		// Expected Result
		// He has to get 5 % discounts since he is member for two years
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 6700*2 =13400
		// Discount on percentage only for ELECTRONICS=670
		// Discount on every 100 =670
		// Hence
		// Total Amount =13400
		// Discount Amount=1340
		// Net Payable=12060
		HashMap<String, Integer> items1 = new HashMap<String, Integer>();
		items1.put("105", 2);

		InvoiceData data1 = invService.generateInvoice(100, items1);
		Assert.assertEquals(0,
				data1.getTotalAmt().compareTo(new BigDecimal(13400)));
		Assert.assertEquals(0,
				data1.getTotalDiscount().compareTo(new BigDecimal(1340)));
		Assert.assertEquals(0,
				data1.getNetPayable().compareTo(new BigDecimal(12060)));

		// Case 3: Employee With Groceries
		// User =101/vinay
		// UserType= Employee
		// 2 Year member
		// Purchasing Items (2)
		// 1
		// Name Wheat
		// Price 45
		// Type:Grocerries
		// Qty 2 kgs
		// 2
		// Name Western Digital Hard Disk 1TB
		// Price 6700
		// Type: Electronics
		// Qty 2 items

		// Expected Result
		// He has to get 30 % discounts since he is Employee
		// He should not get discount on groceries
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 45*2= 90
		// 6700*2 =13400
		// Discount on percentage only for ELECTRONICS=4020
		// Discount on every 100 =670
		// Hence
		// Total Amount =13490
		// Discount Amount=4690
		// Net Payable=8800
		HashMap<String, Integer> items3 = new HashMap<String, Integer>();
		items3.put("102", 2);
		items3.put("105", 2);

		InvoiceData data3 = invService.generateInvoice(101, items3);
		Assert.assertEquals(0,
				data3.getTotalAmt().compareTo(new BigDecimal(13490)));
		Assert.assertEquals(0,
				data3.getTotalDiscount().compareTo(new BigDecimal(4690)));
		Assert.assertEquals(0,
				data3.getNetPayable().compareTo(new BigDecimal(8800)));

		// Case 4: Affiliate With Groceries
		// User =102/Berner Lee
		// UserType= Affiliate
		// 2 Year member
		// Purchasing Items (2)
		// 1
		// Name Wheat
		// Price 45
		// Type:Grocerries
		// Qty 2 kgs
		// 2
		// Name Western Digital Hard Disk 1TB
		// Price 6700
		// Type: Electronics
		// Qty 2 items

		// Expected Result
		// He has to get 10 % discounts since he is Affiliate
		// He should not get discount on groceries
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 45*2= 90
		// 6700*2 =13400
		// Discount on percentage only for ELECTRONICS=1340
		// Discount on every 100 =670
		// Hence
		// Total Amount =13490
		// Discount Amount=2010
		// Net Payable=11480
		HashMap<String, Integer> items4 = new HashMap<String, Integer>();
		items4.put("102", 2);
		items4.put("105", 2);

		InvoiceData data4 = invService.generateInvoice(102, items4);
		Assert.assertEquals(0,
				data4.getTotalAmt().compareTo(new BigDecimal(13490)));
		Assert.assertEquals(0,
				data4.getTotalDiscount().compareTo(new BigDecimal(2010)));
		Assert.assertEquals(0,
				data4.getNetPayable().compareTo(new BigDecimal(11480)));

		// Case 5: Employee Without Groceries
		// User =101/vinay
		// UserType= Employee
		// 2 Year member
		// Purchasing Items (2)
		// 1
		// Name Western Digital Hard Disk 1TB
		// Price 6700
		// Type: Electronics
		// Qty 2 items

		// Expected Result
		// He has to get 30 % discounts since he is Employee
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 6700*2 =13400
		// Discount on percentage only for ELECTRONICS=4020
		// Discount on every 100 =670
		// Hence
		// Total Amount =13400
		// Discount Amount=4690
		// Net Payable=8800
		HashMap<String, Integer> items5 = new HashMap<String, Integer>();
		items5.put("105", 2);

		InvoiceData data5 = invService.generateInvoice(101, items5);
		Assert.assertEquals(0,
				data5.getTotalAmt().compareTo(new BigDecimal(13400)));
		Assert.assertEquals(0,
				data5.getTotalDiscount().compareTo(new BigDecimal(4690)));
		Assert.assertEquals(0,
				data5.getNetPayable().compareTo(new BigDecimal(8710)));

		// Case 6: Affiliate Without Groceries
		// User =102/Berner Lee
		// UserType= Affiliate
		// 2 Year member
		// Purchasing Items (2)
		// 1
		// Name Western Digital Hard Disk 1TB
		// Price 6700
		// Type: Electronics
		// Qty 2 items

		// Expected Result
		// He has to get 10 % discounts since he is Affiliate
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 6700*2 =13400
		// Discount on percentage only for ELECTRONICS=1340
		// Discount on every 100 =670
		// Hence
		// Total Amount =13400
		// Discount Amount=2010
		// Net Payable=11390
		HashMap<String, Integer> items6 = new HashMap<String, Integer>();
		items6.put("105", 2);

		InvoiceData data6 = invService.generateInvoice(102, items6);
		Assert.assertEquals(0,
				data6.getTotalAmt().compareTo(new BigDecimal(13400)));
		Assert.assertEquals(0,
				data6.getTotalDiscount().compareTo(new BigDecimal(2010)));
		Assert.assertEquals(0,
				data6.getNetPayable().compareTo(new BigDecimal(11390)));

		// Case 7: customer less than 2 years with Groceries
		// User =103/Barton
		// UserType= customer
		// Purchasing Items (2)
		// 1
		// Name Wheat
		// Price 45
		// Type:Grocerries
		// Qty 2 kgs
		// 2
		// Name Western Digital Hard Disk 1TB
		// Price 6700
		// Type: Electronics
		// Qty 2 items

		// Expected Result
		// He will not get 5 % discounts since he is not member for two years
		// He should not get discount on groceries
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 45*2= 90
		// 6700*2 =13400
		// Discount on every 100 =670
		// Hence
		// Total Amount =13490
		// Discount Amount=670
		// Net Payable=12150
		HashMap<String, Integer> items7 = new HashMap<String, Integer>();
		items7.put("102", 2);
		items7.put("105", 2);

		InvoiceData data7 = invService.generateInvoice(103, items7);
		Assert.assertEquals(0,
				data7.getTotalAmt().compareTo(new BigDecimal(13490)));
		Assert.assertEquals(0,
				data7.getTotalDiscount().compareTo(new BigDecimal(670)));
		Assert.assertEquals(0,
				data7.getNetPayable().compareTo(new BigDecimal(12820)));

		// Case 8: Total Amount below 100
		// User =103/Barton
		// UserType= customer
		// 2 Year member
		// Purchasing Items (2)
		// 1
		// Name Wheat
		// Price 45
		// Type:Grocerries
		// Qty 2 kgs

		// Expected Result
		// He will not get 5 % discounts since he is not member for two years
		// He should not get discount on groceries
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 45*2= 90
		// Hence
		// Total Amount =90
		// Discount Amount=0
		// Net Payable=90
		HashMap<String, Integer> items8 = new HashMap<String, Integer>();
		items8.put("102", 2);

		InvoiceData data8 = invService.generateInvoice(103, items8);
		Assert.assertEquals(0, data8.getTotalAmt()
				.compareTo(new BigDecimal(90)));
		Assert.assertEquals(0,
				data8.getTotalDiscount().compareTo(new BigDecimal(0)));
		Assert.assertEquals(0,
				data8.getNetPayable().compareTo(new BigDecimal(90)));

		// Case 9: 2 year member Plus Employee
		// User =101/vinay
		// UserType= Employee
		// 2 Year member
		// Purchasing Items (2)
		// 1
		// Name Wheat
		// Price 45
		// Type:Grocerries
		// Qty 2 kgs
		// 2
		// Name Western Digital Hard Disk 1TB
		// Price 6700
		// Type: Electronics
		// Qty 2 items

		// Expected Result
		// He has to get 30 % discounts since he is Employee
		// He should not get discount on groceries and he will not get extra 5 %
		// though he is member for 2 years since he got already the employee
		// benefits
		// He will get 5$ on discount on every 100 $ he spends

		// i.e,
		// 45*2= 90
		// 6700*2 =13400
		// Discount on percentage only for ELECTRONICS=4020
		// Discount on every 100 =670
		// Hence
		// Total Amount =13490
		// Discount Amount=4690
		// Net Payable=8800
		HashMap<String, Integer> items9 = new HashMap<String, Integer>();
		items9.put("102", 2);
		items9.put("105", 2);

		InvoiceData data9 = invService.generateInvoice(101, items9);
		Assert.assertEquals(0,
				data9.getTotalAmt().compareTo(new BigDecimal(13490)));
		Assert.assertEquals(0,
				data9.getTotalDiscount().compareTo(new BigDecimal(4690)));
		Assert.assertEquals(0,
				data9.getNetPayable().compareTo(new BigDecimal(8800)));
	}
}
