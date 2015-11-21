package com.todo.services;

import java.util.HashMap;

import com.todo.view.InvoiceData;

/**
 * Invoice Service to generate an Invoice which will return the Invoice Data
 * 
 * @author Vijayamurugan D
 */
public interface InvoiceService {

	public InvoiceData generateInvoice(int user_id,
			HashMap<String, Integer> itemList);

}
