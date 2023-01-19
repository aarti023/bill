package com.bill.service;

import com.bill.dto.LoginDto;
import com.bill.dto.RelationDto;
import com.bill.enums.UserType;
import com.bill.model.RelationsEntity;

public interface RelationService {

	public RelationsEntity saveRelations(RelationDto relationDto);

	public LoginDto forgetPassword(String email, String employeeCode);

	String getGenrateReportingManagerId(String reportingManagerId);

	String getGenrateUserId(UserType userType, String id);
		

}
