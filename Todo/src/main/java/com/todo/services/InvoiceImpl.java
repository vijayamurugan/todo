package com.todo.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.Product;
import com.todo.entity.ProductType;
import com.todo.entity.User;
import com.todo.entity.UserType;
import com.todo.util.Util;
import com.todo.view.InvoiceData;
import com.todo.view.ItemData;

/**
 * The actual Invoice Implementation 
 * @author Vijayamurugan D
 * 
 */
@Service
public class InvoiceImpl implements InvoiceService {

	private static final BigDecimal EMPLOYEEDISC = new BigDecimal(0.30);
	private static final BigDecimal AFFILIATEDISC = new BigDecimal(0.10);
	private static final BigDecimal TWOYEARSDISC = new BigDecimal(0.05);
	private static final BigDecimal MOREDISC = new BigDecimal(5);

	@Autowired
	private UserDataService userDataService;

	@Autowired
	private ProductDataService productDataService;

	/**
	 * Generate an Invoice and it applies discounts based on the predefined rule
	 * 
	 */
	@Override
	public InvoiceData generateInvoice(int user_id,
			HashMap<String, Integer> itemList) {

		InvoiceData data = null;
		ItemData _ItemData = null;

		List<Product> items = null;
		BigDecimal totalDiscount = BigDecimal.ZERO;
		BigDecimal totalAmount = BigDecimal.ZERO;
		BigDecimal netPayable = BigDecimal.ZERO;
		BigDecimal discountableAmount = BigDecimal.ZERO;
		List<String> _Skus = new ArrayList<String>();
		User user = userDataService.getUserById(user_id);

		if (user != null) {

			/**
			 * Building SKU array to avoid data service calls in loop
			 */
			for (Map.Entry<String, Integer> entry : itemList.entrySet()) {
				_Skus.add(entry.getKey());
			}

			if (_Skus.size() >= 0) {
				items = productDataService.getProducts(_Skus);
			}
			int qty = 0;
			List<ItemData> subLine = new ArrayList<ItemData>();
			for (Product prod : items) {
				_ItemData = new ItemData();
				qty = itemList.get(prod.getSKU()).intValue();
				_ItemData.setItemName(prod.getName());
				_ItemData.setQty(qty);
				_ItemData.setPrice(prod.getPrice()
						.multiply(new BigDecimal(qty)));
				totalAmount = totalAmount.add(prod.getPrice().multiply(
						new BigDecimal(qty)));
				/* The percentage based discounts do not apply on groceries. */
				if (prod.getProductType().compareTo(ProductType.GROCERRIES) != 0) {
					discountableAmount = discountableAmount.add(prod.getPrice()
							.multiply(new BigDecimal(qty)));
				}
				subLine.add(_ItemData);
			}

			// Percentage Discounts
			/*
			 * 1. If the user is an employee of the store, he gets a 30%
			 * discount 2. If the user is an affiliate of the store, he gets a
			 * 10% discount 3. If the user has been a customer for over 2 years,
			 * he gets a 5% discount.
			 */

			/*
			 * A user can get only one of the percentage based discounts on a
			 * bill. IF takes care of this condition
			 */
			if (user.getUserType().compareTo(UserType.AFFILIATE) == 0) {
				totalDiscount = discountableAmount.multiply(AFFILIATEDISC);
			} else if (user.getUserType().compareTo(UserType.EMPLOYEE) == 0) {
				totalDiscount = discountableAmount.multiply(EMPLOYEEDISC);
			} else if (Util.getDiffYears(user.getJoinedDate()) >= 730) {
				totalDiscount = discountableAmount.multiply(TWOYEARSDISC);

			}
			// 5 Dollar Discounts
			int _morediscount = totalAmount.divide(new BigDecimal(100))
					.intValue();
			if (_morediscount > 0) {
				totalDiscount = totalDiscount.add(new BigDecimal(_morediscount)
						.multiply(MOREDISC));
			}

			netPayable = totalAmount.subtract(totalDiscount);
			data = new InvoiceData();
			data.setUserName(user.getName());
			data.setItemList(subLine);
			data.setTotalAmt(totalAmount.setScale(2, RoundingMode.HALF_UP));
			data.setTotalDiscount(totalDiscount.setScale(2,
					RoundingMode.HALF_UP));
			data.setNetPayable(netPayable.setScale(2, RoundingMode.HALF_UP));

		}

		return data;
	}
}
