package com.bill.dto;

import java.util.Date;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseApprovalDto {
	
	private String employeeCode;

	private String employeeName;

	private String email;

	private Date submissionDate;

	private String reportingManager;

	private String brand;

	private String subBrand;

	private String location;

	private String department;

	private String typeOfPurchase;

	private String purchaseDescription;

	private String provisionAmount;

	private String paymentTerms;

	private String paymentMethod;

	private Date purchaseDate;

	private String hodApproval;

	private Date hodAapprovalDate;

	private String hodRemarks;

	private String finalApproval;

	private Date finalApprovalDate;

	private String finalRemarks;
	
	private UserType userType;
	
	private String approvalId;
}
