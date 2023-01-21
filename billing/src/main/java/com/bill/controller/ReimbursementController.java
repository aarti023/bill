package com.bill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bill.dto.ReimbursementDto;
import com.bill.dto.ResponseDto;
import com.bill.model.ReimbursementEntity;
import com.bill.model.UserEntity;
import com.bill.service.FileService;
import com.bill.service.ReimbursementService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/reimbursement")
@Log4j2
@CrossOrigin(origins = "*")
public class ReimbursementController {

	@Autowired
	private ReimbursementService reimbursementService;
	
	@Autowired
	private FileService fileStorageService;
	

	@PostMapping("/save/reimbursement")
	@ApiOperation("save reimbursement details")
	public ResponseDto<ReimbursementEntity> saveReimbursement(@RequestBody ReimbursementDto reimbursementDto) {
		try {
			log.info(" reimbursement {}", reimbursementDto);
			ReimbursementEntity response = reimbursementService.saveReimbursement(reimbursementDto);
			return ResponseDto.success(" Reimbursement details saved successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while saving the  Reimbursement data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while saving the  Reimbursement data " + errorMessage);
		}
	}
	
	@GetMapping("/get/reimbursement/data/{employeeCode}")
	@ApiOperation("get reimbursement detials by employee Code")
	public ResponseDto<List<ReimbursementEntity>> getDetail(@PathVariable("employeeCode") String employeeCode) {
		try {
			log.info("reimbursement {}", employeeCode);
			List<ReimbursementEntity> response = reimbursementService.getReimbursementDataByEmployeeCode(employeeCode);
			return ResponseDto.success("Reimbursement details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the Reimbursement data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	

	@PostMapping("/upload/reimbursement/file")
	public String uploadReimbursementFilesInDB(@RequestParam(value = "file") MultipartFile multiPartFile,
			@RequestParam(name = "employeeCode") String employeeCode) {

		fileStorageService.save(multiPartFile, employeeCode);
		return "File stored successfully";
	}
	
	@GetMapping("/get/reimbursement/")
	@ApiOperation("get all reimbursement")
	public ResponseDto<List<ReimbursementEntity>> getAllReimbursement() {
		try {
			log.info("item {}");
			List<ReimbursementEntity> response = reimbursementService.getAllReimbursementDetails();
			return ResponseDto.success("All Reimbursement details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
}
