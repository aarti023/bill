package com.bill.dto;

import javax.persistence.Column;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

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

	private String invoiceId;

	private UserType userType;

	private String paymentCycle;

	private String taskId;

	private String utr;

	private String paidAmount;

	private String cgstAmount;
	
	private String igstAmount;

	private String sgstAmount;

	private String paymentDate;

	private String paymentStatus;

	private String transactionDetail;
}
