package com.bill.dto;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MergeAllTableDto {
	
	private String dateOfInvoice;

	private String itemCode;

	private String itemName;

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

	private double tds;

	private double tdsAmount;

	private String invoiceId;
	
	private String employeeCode;

	private String employeeName;

	private String email;

	private String invoiceNumber;

	private String invoiceDate;

	private String brand;

	private String subBrand;

	private String location;

	private String department;

	private String category;

	private String subCatagory1;

	private String subCatagory2;

	private String expensesType;

	private double preTaxAmount;

	private double totalAmount;

	private double gstAmount;

	private String paymentMode;

	private String paymentMethod;

	private String payDirectCard;

	private String expensesCategory;

	private String partnerCode;

	private String partnerName;

	private String invoiceDescription;

	private String serviceCategory;

	private String reportingManager;
	
	private UserType userType;
	
	private String paymentCycle;
	
	private String fileName; 
	
	private Long id;

}
