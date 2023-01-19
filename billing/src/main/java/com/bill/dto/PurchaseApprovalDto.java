package com.bill.dto;

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

	private String submissionDate;

	private String reportingManager;

	private String brand;

	private String subBrand;

	private String location;

	private String department;

	private String typeOfPurchase;

	private String purchaseDescription;

	private String provisionAmount;

	private String purchaseDate;

	private String hodApproval;

	private String hodAapprovalDate;

	private String hodRemarks;

	private String finalApproval;

	private String finalApprovalDate;

	private String finalRemarks;
	
	private UserType userType;
	
	private String approvalId;
	
	private String approvalRemarks;
	
	private String reasonOfPurchase;
	
	private String paymentTags;
	
	private String reportingManagerId;
	
	private String highReportingManagerId;

}
