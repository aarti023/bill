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

	@Column(name = "employee_code", columnDefinition = "varchar(256)")
	private String employeeCode;

	@Column(name = "employee_name", columnDefinition = "varchar(256)")
	private String employeeName;
	
	@Column(name = "email", columnDefinition = "varchar(256)")
	private String email;

	@Column(name = "invoice_number", columnDefinition = "varchar(256)")
	private String invoiceNumber;

	@Column(name = "invoice_date", columnDefinition = "varchar(256)")
	private String invoiceDate;

	@Column(name = "brand", columnDefinition = "varchar(256)")
	private String brand;

	@Column(name = "sub_brand", columnDefinition = "varchar(256)")
	private String subBrand;

	@Column(name = "location", columnDefinition = "varchar(256)")
	private String location;

	@Column(name = "department", columnDefinition = "varchar(256)")
	private String department;

	@Column(name = "category", columnDefinition = "varchar(256)")
	private String category;

	@Column(name = "sub_catagory_1", columnDefinition = "varchar(256)")
	private String subCatagory1;

	@Column(name = "sub_catagory_2", columnDefinition = "varchar(256)")
	private String subCatagory2;

	@Column(name = "expenses_type", columnDefinition = "varchar(256)")
	private String expensesType;

	@Column(name = "pre_tax_amount", columnDefinition = "varchar(256)")
	private double preTaxAmount;

	@Column(name = "total_amount", columnDefinition = "varchar(256)")
	private double totalAmount;

	@Column(name = "gst_amount", columnDefinition = "varchar(256)")
	private double gstAmount;

	@Column(name = "payment_Mode", columnDefinition = "varchar(256)")
	private String paymentMode;

	@Column(name = "payment_method", columnDefinition = "varchar(256)")
	private String paymentMethod;

	@Column(name = "pay_direct_card_details", columnDefinition = "varchar(256)")
	private String payDirectCard;

	@Column(name = "expenses_category", columnDefinition = "varchar(256)")
	private String expensesCategory;

	@Column(name = "partner_name_code", columnDefinition = "varchar(256)")
	private String partnerNameCode;

	@Column(name = "other_partner", columnDefinition = "varchar(256)")
	private String otherPartner;

	@Column(name = "invoice_description", columnDefinition = "varchar(256)")
	private String invoiceDescription;

	@Column(name = "service_category", columnDefinition = "varchar(256)")
	private String serviceCategory;

	@Column(name = "reporting_manager", columnDefinition = "varchar(256)")
	private String reportingManager;
	
	@Column(name = "invoice_id", columnDefinition = "varchar(10)")
	private String invoiceId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", columnDefinition = "varchar(50)")
	private UserType userType;
	
	@Column(name = "payment_cycle", columnDefinition = "varchar(256)")
	private String paymentCycle;
	
	@Column(name = "task_id", columnDefinition = "varchar(50)")
	private String taskId;
	
	@Column(name = "utr", columnDefinition = "varchar(50)")
	private String utr;
	
	@Column(name = "paid_amount", columnDefinition = "varchar(256)")
	private String paidAmount;
	
	@Column(name = "payment_date", columnDefinition = "varchar(256)")
	private String paymentDate;
	
	@Column(name = "payment_status", columnDefinition = "varchar(256)")
	private String paymentStatus;
	
	@Column(name = "transaction_detail", columnDefinition = "varchar(256)")
	private String transactionDetail;

	@Column(name = "updated_by", columnDefinition = "varchar(256)")
	private String updatedBy;

	@Column(name = "updated_at", columnDefinition = "varchar(256)")
	private String updatedAt;
	
	@Column(name = "cgst_amount", columnDefinition = "varchar(256)")
	private String cgstAmount;
	
	@Column(name = "igst_amount", columnDefinition = "varchar(256)")
	private String igstAmount;
	
	@Column(name = "sgst_amount", columnDefinition = "varchar(256)")
	private String sgstAmount;
	
	@Column(name = "reimbursement_date", columnDefinition = "varchar(256)")
	private String reimbursementDate;

}
