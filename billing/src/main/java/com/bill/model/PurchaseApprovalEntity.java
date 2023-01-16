package com.bill.model;

import java.util.Date;

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
	private Date submissionDate;
	
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
	
	@Column(name = "payment_terms", columnDefinition = "varchar(256)")
	private String paymentTerms;
	
	@Column(name = "payment_method", columnDefinition = "varchar(256)")
	private String paymentMethod;
	
	@Column(name = "purchase_date", columnDefinition = "varchar(256)")
	private Date purchaseDate;
	
	@Column(name = "hod_approval", columnDefinition = "varchar(256)")
	private String hodApproval;
	
	@Column(name = "hod_approval_date", columnDefinition = "varchar(256)")
	private Date hodAapprovalDate;
	
	@Column(name = "hod_remarks", columnDefinition = "varchar(256)")
	private String hodRemarks;
	
	@Column(name = "final_approval", columnDefinition = "varchar(256)")
	private String finalApproval;
	
	@Column(name = "final_approval_date", columnDefinition = "varchar(256)")
	private Date finalApprovalDate;
	
	@Column(name = "final_remarks", columnDefinition = "varchar(256)")
	private String finalRemarks;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", columnDefinition = "varchar(50)")
	private UserType userType;
	
	
	
}
