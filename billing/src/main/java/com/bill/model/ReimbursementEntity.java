package com.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "reimbursement")
@Entity(name = "reimbursement")
public class ReimbursementEntity {
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
	
	@Column(name = "brand", columnDefinition = "varchar(256)")
	private String brand;

	@Column(name = "sub_brand", columnDefinition = "varchar(256)")
	private String subBrand;
	
	@Column(name = "location", columnDefinition = "varchar(256)")
	private String location;
	
	@Column(name = "department", columnDefinition = "varchar(256)")
	private String department;
	
	@Column(name = "reimbursement_type", columnDefinition = "varchar(256)")
	private String reimbursementType;
	
	@Column(name = "petrol_amount", columnDefinition = "varchar(256)")
	private String petrolAmount;
	
	@Column(name = "driver_salary", columnDefinition = "varchar(256)")
	private String driverSalary;	
	
	@Column(name = "reporting_manager", columnDefinition = "varchar(256)")
	private String reportingManager;
	
	@Column(name = "total_amount", columnDefinition = "varchar(256)")
	private String totalAmount;
	
	@Column(name = "convense_amount", columnDefinition = "varchar(256)")
	private String convenseAmount;
	
	@Column(name = "food", columnDefinition = "varchar(256)")
	private String food;
	
	@Column(name = "mobile_internet", columnDefinition = "varchar(256)")
	private String internet;
	
	@Column(name = "accommodation", columnDefinition = "varchar(256)")
	private String accommodation;
	
	@Column(name = "other_business_amount", columnDefinition = "varchar(256)")
	private String otherBusinessAmount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", columnDefinition = "varchar(50)")
	private UserType userType;
	
	@Column(name = "reporting_manager_id", columnDefinition = "varchar(256)")
	private String reportingManagerId;
	
	@Column(name = "high_reporting_manager_id", columnDefinition = "varchar(256)")
	private String highReportingManagerId;
}
