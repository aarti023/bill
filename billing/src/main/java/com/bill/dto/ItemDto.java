package com.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

	private String invoiceNumber;

	private String dateOfInvoice;

	private String itemNameCode;

	private String categoryItem;

	private String unit;

	private double quantity;

	private double rate;

	private double amount;

	private double gstAmountItem;

	private double discount;

	private double amountPaid;

	private double redeemed;

	private double cgst;

	private double igst;

	private double sgst;

	private String invoiceId;
	
	private String addNewItem;

}
