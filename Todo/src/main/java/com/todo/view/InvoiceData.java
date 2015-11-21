package com.todo.view;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceData {

	private String userName;
	private List<ItemData> itemList;

	private BigDecimal totalAmt;

	private BigDecimal totalDiscount;

	private BigDecimal netPayable;

	public List<ItemData> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemData> itemList) {
		this.itemList = itemList;
	}

	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}



	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public BigDecimal getNetPayable() {
		return netPayable;
	}

	public void setNetPayable(BigDecimal netPayable) {
		this.netPayable = netPayable;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
