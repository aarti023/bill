package com.bill.dto;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelationDto {

	private String employeeCode;

	private String employeeName;

	private String email;
	
	private UserType userType;
	
	private String reportingManager;
	
	private String reportingManagerId;
	
	private String submissionDate;
	
	private String highReportingManagerId;
	
}
