package com.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "purchaseApproval")
@Entity(name = "purchaseApproval")
public class PurchaseApprovalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "approval_id", columnDefinition = "varchar(256)")
	private String approvalId;

	@Column(name = "employee_code", columnDefinition = "varchar(256)")
	private String employeeCode;

	@Column(name = "employee_name", columnDefinition = "varchar(256)")
	private String employeeName;

	@Column(name = "email", columnDefinition = "varchar(256)")
	private String email;

	@Column(name = "submission_date", columnDefinition = "varchar(256)")
	private String submissionDate;

	@Column(name = "reporting_manager", columnDefinition = "varchar(256)")
	private String reportingManager;

	@Column(name = "brand", columnDefinition = "varchar(256)")
	private String brand;

	@Column(name = "sub_brand", columnDefinition = "varchar(256)")
	private String subBrand;

	@Column(name = "location", columnDefinition = "varchar(256)")
	private String location;

	@Column(name = "department", columnDefinition = "varchar(256)")
	private String department;

	@Column(name = "type_of_purchase", columnDefinition = "varchar(256)")
	private String typeOfPurchase;

	@Column(name = "purchase_description", columnDefinition = "varchar(256)")
	private String purchaseDescription;

	@Column(name = "provision_amount", columnDefinition = "varchar(256)")
	private String provisionAmount;

	@Column(name = "purchase_date", columnDefinition = "varchar(256)")
	private String purchaseDate;

	@Column(name = "hod_approval", columnDefinition = "varchar(256)")
	private String hodApproval;

	@Column(name = "hod_approval_date", columnDefinition = "varchar(256)")
	private String hodAapprovalDate;

	@Column(name = "hod_remarks", columnDefinition = "varchar(256)")
	private String hodRemarks;

	@Column(name = "final_approval", columnDefinition = "varchar(256)")
	private String finalApproval;

	@Column(name = "final_approval_date", columnDefinition = "varchar(256)")
	private String finalApprovalDate;

	@Column(name = "final_remarks", columnDefinition = "varchar(256)")
	private String finalRemarks;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", columnDefinition = "varchar(50)")
	private UserType userType;

	@Column(name = "approval_remarks", columnDefinition = "varchar(256)")
	private String approvalRemarks;

	@Column(name = "reason_of_purchase", columnDefinition = "varchar(256)")
	private String reasonOfPurchase;

	@Column(name = "payment_tags", columnDefinition = "varchar(256)")
	private String paymentTags;

	@Column(name = "reporting_manager_id", columnDefinition = "varchar(256)")
	private String reportingManagerId;

	@Column(name = "high_reporting_manager_id", columnDefinition = "varchar(256)")
	private String highReportingManagerId;

	@Column(name = "payment_mode", columnDefinition = "varchar(256)")
	private String paymentMode;

	@Column(name = "payment_method", columnDefinition = "varchar(256)")
	private String paymentMethod;
	
	@Column(name = "urgent_payment_remarks", columnDefinition = "varchar(256)")
	private String urgentPaymentRemarks;

	@Column(name = "paid_amount", columnDefinition = "varchar(256)")
	private String paidAmount;

	@Column(name = "rembursement_payment_date", columnDefinition = "varchar(256)")
	private String rembursementPaymentDate;

	@Column(name = "payment_status", columnDefinition = "varchar(256)")
	private String paymentStatus;

	@Column(name = "transaction_details", columnDefinition = "varchar(256)")
	private String transactionDetails;
	
	@Column(name = "approve_status", columnDefinition = "varchar(256)")
	private String approveStatus;

}
