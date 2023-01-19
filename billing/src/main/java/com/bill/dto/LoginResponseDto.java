package com.bill.dto;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

	private String employeeCode;

	private String employeeName;

	private String email;

	private Boolean status;

	private UserType userType;

	private String ReportingManager;

	private String submissionDate;

	private String reportingManagerId;
	
	private String highReportingManagerId;

}
