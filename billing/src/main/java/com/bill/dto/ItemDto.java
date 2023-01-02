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
		
	private String source;
	
	private String itemCode;
	
	private String itemName;
	
	private String hSNCode;
	
	private String category;
	
	private double quantity;
	
	private String unit;
	
	private double price;
	
	private double amount;
	
	private String gSTSlab;
	
	private double gSTAmount;
	
	private double discount;
	
	private double redeemed;
	
	private double amountPaid;
	
}
