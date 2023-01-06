package com.bill.service;

import com.bill.dto.LoginDto;
import com.bill.dto.LoginResponseDto;
import com.bill.model.LoginEntity;

public interface LoginService {
	
	LoginResponseDto saveLogin(LoginDto loginDto);
}
