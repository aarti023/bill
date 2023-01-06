package com.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.LoginDto;
import com.bill.dto.LoginResponseDto;
import com.bill.dto.ResponseDto;
import com.bill.dto.UserDto;
import com.bill.model.LoginEntity;
import com.bill.model.UserEntity;
import com.bill.service.LoginService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/login")
@Log4j2
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/save")
	@ApiOperation("save user details")
	public ResponseDto<LoginResponseDto> saveLogin( @RequestBody LoginDto loginDto) {
		try {
			log.info("login{}", loginDto);
			LoginResponseDto response = loginService.saveLogin(loginDto);
			return ResponseDto.success("login details saved successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while login the data is {}", errorMessage);
			return ResponseDto.failure("Please enter right data " + errorMessage);
		}
	}

}
