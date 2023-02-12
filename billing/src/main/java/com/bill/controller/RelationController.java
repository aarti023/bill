package com.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.LoginDto;
import com.bill.dto.RelationDto;
import com.bill.dto.ResponseDto;
import com.bill.model.RelationsEntity;
import com.bill.service.RelationService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/relation")
@Log4j2
public class RelationController {
	
	@Autowired
	private RelationService relationService;
	
	@PostMapping("/save/details")
	@ApiOperation("save relations details")
	public ResponseDto<RelationsEntity> saveDetail( @RequestBody RelationDto relationDto) {
		try {
			log.info("relation {}", relationDto);
			RelationsEntity response = relationService.saveRelations(relationDto);
			return ResponseDto.success("relation details saved successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while relating the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while relating the data " + errorMessage);
		}
	}
	
	@PostMapping("/save/passowrd/forget")
	@ApiOperation("save relations details")
	public ResponseDto<LoginDto> saveforgetPassword(@RequestParam("email") String email, @RequestParam("employeeCode") String employeeCode) {
		try {
			log.info("relation {}",email, employeeCode);
			LoginDto response = relationService.forgetPassword(email,employeeCode);
			return ResponseDto.success("relation details saved successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while relating the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while relating the data " + errorMessage);
		}
	}

}
