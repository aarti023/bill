package com.bill.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.MergeAllTableDto;
import com.bill.dto.ResponseDto;
import com.bill.dto.UserDto;
import com.bill.dto.UserUpdateDto;
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
	
//	@GetMapping("/get/abababa/{employeeId}")
//	@ApiOperation("get detials by id")
//	public ResponseDto<UserEntity> getDetailByEmployee(@PathVariable("employeeId") String employeeId) {
//		try {
//			log.info("user {}", employeeId);
//			UserEntity response = userService.getNameAndEmailByEmployeeId(employeeId);
//			return ResponseDto.success("user details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}
	
	@GetMapping("/get/name/email/{employeeId}")
	@ApiOperation("get name and email by employeeId")
	public ResponseDto getDetailByEmployee(@PathVariable("employeeId") String employeeId) {
		try {
			log.info("user {}", employeeId);
			String response = userService.getNameAndEmailByEmployeeId(employeeId);
			return ResponseDto.success("user details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}

	
	@GetMapping("/gets/")
	@ApiOperation("get all details of merge data")
	public ResponseDto<List<MergeAllTableDto>> getAll() {
		try {
			log.info("user {}");
			List<MergeAllTableDto> response = userService.getAll();
			return ResponseDto.success("All User details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
//	@PutMapping("/update/{invoiceId}")
//	@ApiOperation("update user details")
//	public ResponseDto<UserEntity> updateDetail( @RequestBody UserUpdateDto userUpdateDto, UserEntity user, @PathVariable("invoiceId") String invoiceId) {
//		try {
//			log.info("user {}", userUpdateDto);
//			UserEntity response = userService.updateUser(user, userUpdateDto);
//			return ResponseDto.success("user details update successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while saving the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while updating the data " + errorMessage);
//		}
//	}
	
}
