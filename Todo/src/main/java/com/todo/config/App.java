package com.todo.config;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.todo.services.InvoiceService;
import com.todo.view.InvoiceData;
import com.todo.view.ItemData;

/**
 * A main class which demonstrates the services invocation and the
 * functionalities
 * 
 * @author Vijayamurugan D
 *
 */
public class App {

	public static void main(String args[]) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				ServiceConfig.class);
		InvoiceService obj = (InvoiceService) context
				.getBean(InvoiceService.class);

		HashMap<String, Integer> items = new HashMap<String, Integer>();
		items.put("102", 2);
		 items.put("105", 2);
		InvoiceData data = obj.generateInvoice(103, items);

		System.out
				.println("---------------------------Invoice ---------------------------");
		System.out.println(" ");
		System.out
				.println("------------------------Customer Details----------------------");
		System.out.println(" ");
		System.out.println(data.getUserName());
		System.out.println(" ");
		System.out
				.println("------------------------Item Details----------------------");
		System.out.println("S.No  Item   Qty    Price");
		System.out.println(" ");
		int i = 1;
		for (ItemData item : data.getItemList()) {
			System.out.print(i);
			System.out.print("     ");
			System.out.print(item.getItemName());
			System.out.print("   ");
			System.out.print(item.getQty());
			System.out.print("   ");
			System.out.print(item.getPrice());
			System.out.println("   ");
			System.out.println("   ");
			i++;

		}
		System.out
				.println("----------------------------------------------------------");
		System.out.println("                             Total Amount :"
				+ data.getTotalAmt());
		System.out.println("                                 Discount :"
				+ data.getTotalDiscount());
		System.out.println("                             Net Payable  :"
				+ data.getNetPayable());
		System.out
				.println("----------------------------------------------------------");

	}
}
