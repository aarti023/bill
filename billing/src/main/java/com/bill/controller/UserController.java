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

import com.bill.dto.InvoiceStatusUpdateDto;
import com.bill.dto.ResponseDto;
import com.bill.dto.UserDto;
import com.bill.dto.UserUpdateDto;
import com.bill.model.UserEntity;
import com.bill.repository.UserRepo;
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
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	@ApiOperation("wellcome")
	public String say() {
		return "WellCome";
	}
	
	@PostMapping("/save")
	@ApiOperation("save user details")
	public ResponseDto<UserEntity> saveDetail(@RequestBody UserDto userDto) {
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

	@PutMapping("/update/{invoiceId}")
	@ApiOperation("update user details")
	public ResponseDto<UserUpdateDto> updateDetail(@PathVariable("invoiceId") String invoiceId,
			@RequestBody UserUpdateDto userUpdateDto) {
		try {
			log.info("user {}", invoiceId);
			UserUpdateDto response = userService.updateUser(invoiceId, userUpdateDto);
			return ResponseDto.success("user details update successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while saving the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while updating the data " + errorMessage);
		}
	}

	@PutMapping("/update/invoiceStatus/{invoiceId}")
	@ApiOperation("update reason")
	public ResponseDto<InvoiceStatusUpdateDto> updateInvoiceStatus(@PathVariable("invoiceId") String invoiceId,
			@RequestBody InvoiceStatusUpdateDto invoiceStatusUpdateDto) {
		try {
			log.info("user {}", invoiceId);
			InvoiceStatusUpdateDto response = userService.updateInvoiceStatus(invoiceId, invoiceStatusUpdateDto);
			return ResponseDto.success("user details update successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while saving the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while updating the data " + errorMessage);
		}
	}

	@GetMapping("/get/data/reportingManager/{reportingManagerId}")
	@ApiOperation("get detials by Reporting Manager Id")
	public ResponseDto<List<UserEntity>> getDetailByReportingManagerId(@PathVariable("reportingManagerId") String reportingManagerId) {
		try {
			log.info("user {}", reportingManagerId);
			List<UserEntity> response = userService.getDataReportingManagerId(reportingManagerId);
			return ResponseDto.success("user details get successfully by Reporting ManagerId", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}

	@GetMapping("/get/data/{employeeCode}")
	@ApiOperation("get detials by employee Code")
	public ResponseDto<List<UserEntity>> getDetail(@PathVariable("employeeCode") String employeeCode) {
		try {
			log.info("user {}", employeeCode);
			List<UserEntity> response = userService.getDataByEmployeeCode(employeeCode);
			return ResponseDto.success("user details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}

	@GetMapping("/search")
	public ResponseDto<List<UserEntity>> searchUser(@RequestParam(value = "employeeName") String employeeName,
															  @RequestParam(value = "email") String email){
		try {
			log.info("user {}", employeeName);
			List<UserEntity> response = userRepo.findByEmployeeNameAndEmail(employeeName, email);
			return ResponseDto.success("user details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
	
//	@GetMapping("/search")
//	public ResponseDto<List<UserDto>> searchUsers(@RequestParam(value = "employeeName") String employeeName,
//												  @RequestParam(value = "email") String email){
//		try {
//			log.info("user {}", employeeName);
////			List<UserDto> response = userRepo.findByEmployeeNameAndEmail(employeeName, email);
////			List<UserDto> response = userService.searchUser()
//			return ResponseDto.success("user details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}
	
	
	
//	@GetMapping("/get/name/email/{employeeCode}")
//	@ApiOperation("get name and email by employeeCode")
//	public ResponseDto<EmployeeCodeDto> getDetailByEmployeeCode(@PathVariable("employeeCode") String employeeCode) {
//		try {
//			log.info("user {}", employeeCode);
//			EmployeeCodeDto response = userService.getNameAndEmailByEmployeeCode(employeeCode);
//			return ResponseDto.success("user details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

//	@GetMapping("/gets/")
//	@ApiOperation("get all details of merge data")
//	public ResponseDto<List<MergeAllTableDto>> getAll() {
//		try {
//			log.info("user {}");
//			List<MergeAllTableDto> response = userService.getAll();
//			return ResponseDto.success("All User details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

}
