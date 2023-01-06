package com.bill.dto;

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

	private String password;
	
}
