package com.bill.dto;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReimbursementDto {

	private String employeeCode;

	private String employeeName;

	private String email;
	
	private String brand;

	private String subBrand;
	
	private String location;
	
	private String department;
	
	private String reimbursementType;
	
	private String petrolAmount;
	
	private String driverSalary;	
	
	private String reportingManager;
	
	private String totalAmount;
	
	private String convenseAmount;
	
	private String food;
	
	private String internet;
	
	private String accommodation;
	
	private String otherBusinessAmount;
	
	private UserType userType;
	
	private String reportingManagerId;
	
	private String highReportingManagerId;
	
	private String reimburseId;
}
