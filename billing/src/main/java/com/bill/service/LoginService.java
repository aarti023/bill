package com.bill.service;

import com.bill.dto.LoginDto;
import com.bill.dto.LoginResponseDto;

public interface LoginService {
	
	LoginResponseDto saveLogin(LoginDto loginDto);

	String logOut(String email, String employeeCode);
}
