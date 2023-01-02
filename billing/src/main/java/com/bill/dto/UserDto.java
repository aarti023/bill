package com.bill.dto;

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

	private String catagory;

	private String subCatagory1;

	private String subCatagory2;

	private String expensesType;

	private double preTaxAmount;

	private double totalAmount;

	private double gSTApplicable;

	private double tdsTpye;

	private double tdsAmount;

	private String paymentMode;

	private String paymentMethod;

	private String payDirectCard;

	private String expensesCategory;

	private String partnerCode;

	private String partnerName;

	private String invoiceDescription;

	private String serviceCategory;

	private String invoiceAttachment;

	private String paymentStatus;

	private String reportingManager;

}