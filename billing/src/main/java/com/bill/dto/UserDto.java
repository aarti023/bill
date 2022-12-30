package com.bill.dto;

import javax.persistence.Column;

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

	private String preTaxAmount;

	private String totalAmount;

	private String GSTApplicaiton;

	private String TDSTpye;

	private String TDSAmount;

	private String paymentMode;

	private String paymentMethod;

	private String payDirectCardDetails;

	private String expensesCategory;

	private String partnerCode;

	private String partnerName;

	private String invoiceDescription;

	private String serviceCategory;

	private String invoiceAttachment;

	private String paymentStatus;
}
