package com.bill.service;

import java.util.List;

import com.bill.dto.EmployeeCodeDto;
import com.bill.dto.MergeAllTableDto;
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

	List<MergeAllTableDto> getAll();

	EmployeeCodeDto getNameAndEmailByEmployeeCode(String employeeCode);

	UserUpdateDto updateUser(String invoiceId,UserUpdateDto userUpdateDto);

	List<UserEntity> getDataByEmployeeCode(String employeeCode);

}
