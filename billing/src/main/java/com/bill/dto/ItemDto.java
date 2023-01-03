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

	private String itemCode;

	private String itemName;

	private String category;

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

	private double tds;

	private double tdsAmount;

	private String invoiceId;

}
