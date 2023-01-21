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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity(name = "user")
public class UserEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "invoice_type", columnDefinition = "varchar(256)")
	private String InvoiceType;
	
	@Column(name = "payment_status", columnDefinition = "varchar(256)")	
	private String paymentStatus;
	
	@Column(name = "invoice_number", columnDefinition = "varchar(256)")
	private String invoiceNumber;

	@Column(name = "invoice_date", columnDefinition = "varchar(256)")
	private String invoiceDate;

	@Column(name = "payment_date", columnDefinition = "varchar(256)")
	private String paymentDate;

	@Column(name = "utr_mendatory", columnDefinition = "varchar(256)")
	private String utrMendatory;

	@Column(name = "brand", columnDefinition = "varchar(256)")
	private String brand;

	@Column(name = "sub_brand", columnDefinition = "varchar(256)")
	private String subBrand;
	
	@Column(name = "customer_name", columnDefinition = "varchar(256)")
	private String customerName;

	@Column(name = "location", columnDefinition = "varchar(256)")
	private String location;

	@Column(name = "expenses_type", columnDefinition = "varchar(256)")
	private String expensesType;

	@Column(name = "expenses_category", columnDefinition = "varchar(256)")
	private String expensesCategory;
	
	@Column(name = "department", columnDefinition = "varchar(256)")
	private String department;

	@Column(name = "category", columnDefinition = "varchar(256)")
	private String category;

	@Column(name = "sub_catagory1", columnDefinition = "varchar(256)")
	private String subCatagory1;

	@Column(name = "sub_catagory2", columnDefinition = "varchar(256)")
	private String subCatagory2;

	@Column(name = "gst_applicable", columnDefinition = "varchar(256)")
	private String gstApplicable;
	
	@Column(name = "tds_applicable", columnDefinition = "varchar(256)")
	private String tdsApplicable;

	@Column(name = "pre_tax_amount", columnDefinition = "varchar(256)")
	private double preTaxAmount;

	@Column(name = "tds_percentage", columnDefinition = "varchar(256)")
	private String tdsPercentage;

	@Column(name = "tds_amount", columnDefinition = "varchar(256)")
	private String tdsAmount;

	@Column(name = "gst_amount", columnDefinition = "varchar(256)")
	private String gstAmount;

	@Column(name = "total_amount", columnDefinition = "varchar(256)")
	private double totalAmount;

	@Column(name = "net_amount", columnDefinition = "varchar(256)")
	private String netAmount;

	@Column(name = "payment_mode", columnDefinition = "varchar(256)")
	private String paymentMode;

	@Column(name = "payment_method", columnDefinition = "varchar(256)")
	private String paymentMethod;

	@Column(name = "pay_direct_card", columnDefinition = "varchar(256)")
	private String payDirectCard;

	@Column(name = "partner_name_code", columnDefinition = "varchar(256)")
	private String partnerNameCode;

	@Column(name = "other_partner", columnDefinition = "varchar(256)")
	private String otherPartner;

	@Column(name = "invoice_description", columnDefinition = "varchar(256)")
	private String invoiceDescription;

	@Column(name = "employee_code", columnDefinition = "varchar(256)")
	private String employeeCode;

	@Column(name = "employee_name", columnDefinition = "varchar(256)")
	private String employeeName;

	@Column(name = "email", columnDefinition = "varchar(256)")
	private String email;

	@Column(name = "paid_amount", columnDefinition = "varchar(256)")
	private String paidAmount;

	@Column(name = "update_payment_status", columnDefinition = "varchar(256)")
	private String updatePaymentStatus;

	@Column(name = "transaction_detail", columnDefinition = "varchar(256)")
	private String transactionDetail;

	@Column(name = "reporting_manager", columnDefinition = "varchar(256)")
	private String reportingManager;

	@Column(name = "reporting_manager_id", columnDefinition = "varchar(256)")
	private String reportingManagerId;

	@Column(name = "reimbursement_date", columnDefinition = "varchar(256)")
	private String reimbursementDate;

	@Column(name = "invoice_status", columnDefinition = "varchar(256)")
	private String invoiceStatus;

	@Column(name = "high_reportingManager_id", columnDefinition = "varchar(256)")
	private String highReportingManagerId;
	
	@Column(name = "invoice_id", columnDefinition = "varchar(10)")
	private String invoiceId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", columnDefinition = "varchar(50)")
	private UserType userType;
	
	@Column(name = "task_id", columnDefinition = "varchar(50)")
	private String taskId;
	
	@Column(name = "utr", columnDefinition = "varchar(50)")
	private String utr;
	
	@Column(name = "approval_id", columnDefinition = "varchar(256)")
	private String approvalId;
	
	@Column(name = "is_reimbursement", columnDefinition = "varchar(256)")
	private String isReimbursement;


}
