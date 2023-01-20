package com.bill.dto;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String InvoiceType;

	private String paymentStatus;

	private String invoiceNumber;

	private String invoiceDate;

	private String paymentDate;

	private String utrMendatory;

	private String brand;

	private String subBrand;

	private String customerName;

	private String location;

	private String expensesType;

	private String expensesCategory;
	
	private String department;

	private String category;

	private String subCatagory1;

	private String subCatagory2;

	private String gstApplicable;

	private String tdsApplicable;

	private double preTaxAmount;

	private String tdsPercentage;

	private String tdsAmount;

	private String gstAmount;

	private double totalAmount;

	private String netAmount;

	private String paymentMode;

	private String paymentMethod;

	private String payDirectCard;

	private String partnerNameCode;

	private String otherPartner;

	private String invoiceDescription;

	private String taskId;

	private String utr;

	private String employeeCode;

	private String employeeName;

	private String email;

	private String paidAmount;

	private String updatePaymentStatus;

	private String transactionDetail;

	private String reportingManager;

	private String invoiceId;

	private UserType userType;

	private String reportingManagerId;

	private String reimbursementDate;

	private String invoiceStatus;

	private String highReportingManagerId;
	
	private String approvalId;

}
