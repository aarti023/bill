package com.bill.service;

import java.util.List;

import com.bill.dto.EmployeeCodeDto;
import com.bill.dto.InvoiceStatusUpdateDto;
import com.bill.dto.UserDto;
import com.bill.dto.UserUpdateDto;
import com.bill.enums.UserType;
import com.bill.model.UserEntity;

public interface UserService {
	
	UserEntity saveUser(UserDto userDto);

	List<UserEntity> getAllUserDetails();

	UserEntity getSavedDataById(Long id);

	List<UserEntity> findByInvoiceNumber(String invoiceNumber);

	String getGenrateUserId(UserType userType, String id);

	EmployeeCodeDto getNameAndEmailByEmployeeCode(String employeeCode);

	UserUpdateDto updateUser(String invoiceId, UserUpdateDto userUpdateDto);

	List<UserEntity> getDataByEmployeeCode(String employeeCode);

	List<UserEntity> getDataReportingManagerId(String reportingManagerId);

	InvoiceStatusUpdateDto updateInvoiceStatus(String invoiceId, InvoiceStatusUpdateDto invoiceStatusUpdateDto);

	List<UserEntity> getDetailsByName(String employeeName, UserEntity userEntity);

}
