//package com.bill.wellserved.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bill.dto.ResponseDto;
//import com.bill.model.UserEntity;
//import com.bill.wellserved.dto.WellServedDto;
//import com.bill.wellserved.model.WellServedEntity;
//import com.bill.wellserved.service.WellServedService;
//
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.log4j.Log4j2;
//
//@RestController
//@RequestMapping("/wellserved")
//@Log4j2
//@CrossOrigin(origins = "*")
//public class WellservedController {
//	@Autowired
//	private WellServedService wellServedService;
//
//	@PostMapping("/save")
//	@ApiOperation("save user details")
//	public ResponseDto<WellServedEntity> saveDetail(@RequestBody WellServedDto wellServedDto) {
//		try {
//			log.info("wellserved {}", wellServedDto);
//			WellServedEntity response = wellServedService.saveCustomer(wellServedDto);
//			return ResponseDto.success("user details saved successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while saving the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while saving the data " + errorMessage);
//		}
//	}
//
//	@GetMapping("/get/wellserved/data/all")
//	@ApiOperation("get all details")
//	public ResponseDto<List<WellServedEntity>> getAllDetails() {
//		try {
//			log.info("wellserved {}");
//			List<WellServedEntity> response = wellServedService.getAllCustomerDetails();
//			return ResponseDto.success("All User details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}
//
//}
