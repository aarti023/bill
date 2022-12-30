package com.bill.service;

import java.util.List;

import com.bill.dto.UserDto;
import com.bill.model.UserEntity;

public interface UserService {
	UserEntity saveUser(UserDto userDto);

	List<UserEntity> getAllUserDetails();

	UserEntity getSavedDataById(Long id);
}
