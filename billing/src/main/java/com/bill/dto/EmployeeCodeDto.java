package com.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCodeDto {

	private String employeeName;
	
	private String email;
	
	private String reportingManager;
	
}
