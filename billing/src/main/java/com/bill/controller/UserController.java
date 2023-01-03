package com.bill.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.ResponseDto;
import com.bill.dto.UserDto;
import com.bill.model.UserEntity;
import com.bill.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
@RestController
@RequestMapping("/bill")
@Log4j2
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	@ApiOperation("save user details")
	public ResponseDto<UserEntity> saveDetail( @RequestBody UserDto userDto) {
		try {
			log.info("user {}", userDto);
			UserEntity response = userService.saveUser(userDto);
			return ResponseDto.success("user details saved successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while saving the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while saving the data " + errorMessage);
		}
	}

//	@GetMapping("/get/data/{id}")
//	@ApiOperation("get detials by id")
//	public ResponseDto<UserEntity> getDetails(@PathVariable("id") Long id) {
//		try {
//			log.info("user {}", id);
//			UserEntity response = userService.getSavedDataById(id);
//			return ResponseDto.success("user details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

	@GetMapping("/get/data/all")
	@ApiOperation("get all details")
	public ResponseDto<List<UserEntity>> getAllDetails() {
		try {
			log.info("user {}");
			List<UserEntity> response = userService.getAllUserDetails();
			return ResponseDto.success("All User details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
	@GetMapping("/get/data/{invoiceNumber}")
	@ApiOperation("get detials by id")
	public ResponseDto<List<UserEntity>> getDetail(@PathVariable("invoiceNumber") String invoiceNumber) {
		try {
			log.info("user {}", invoiceNumber);
			List<UserEntity> response = userService.findByInvoiceNumber(invoiceNumber);
			return ResponseDto.success("user details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
}
