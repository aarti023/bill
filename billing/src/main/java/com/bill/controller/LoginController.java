package com.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.LoginDto;
import com.bill.dto.LoginResponseDto;
import com.bill.dto.ResponseDto;
import com.bill.service.LoginService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/login")
@Log4j2
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/login")
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
	
	@PostMapping("/logout")
	@ApiOperation("logout details")
	public ResponseDto<String> logOut(@RequestParam("email") String email, @RequestParam("employeeCode") String employeeCode) {
		try {
			log.info("logout {}",email, employeeCode);
			String response = loginService.logOut(email,employeeCode);
			return ResponseDto.success("logout successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while relating the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while logout the user " + errorMessage);
		}
	}
	
	
	

}
