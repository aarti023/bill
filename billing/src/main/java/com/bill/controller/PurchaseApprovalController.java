package com.bill.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.PurchaseApprovalByCOSDto;
import com.bill.dto.PurchaseApprovalByHODDto;
import com.bill.dto.PurchaseApprovalDto;
import com.bill.dto.ResponseDto;
import com.bill.model.PurchaseApprovalEntity;
import com.bill.service.impl.PurchaseApprovalServiceImpl;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/purchaseApproval")
@Log4j2
@CrossOrigin(origins = "*")
public class PurchaseApprovalController {

	@Autowired
	private PurchaseApprovalServiceImpl purchaseApprovalServiceImpl;

	@PostMapping("/save/purchase")
	@ApiOperation("save purchase approval details")
	public ResponseDto<PurchaseApprovalEntity> savePurchaseApproval(
			@RequestBody PurchaseApprovalDto purchaseApprovalDto) {
		try {
			log.info("purchase approval {}", purchaseApprovalDto);
			PurchaseApprovalEntity response = purchaseApprovalServiceImpl.savePurchase(purchaseApprovalDto);
			return ResponseDto.success("purchase approval save successfully", response);
		} catch (Exception errorMessage) {
			log.error("error while saving the purchase approval data", errorMessage);
			return ResponseDto.failure("Exception ocurred while saving the data of purchase approval " + errorMessage);
		}
	}

	@GetMapping("get/data/all/purchase/approval")
	@ApiOperation("get all details of purchase approval")
	public ResponseDto<List<PurchaseApprovalEntity>> getDataPurchaseApproval() {
		try {
			log.info("getting data of Purchase Approval {}");
			List<PurchaseApprovalEntity> response = purchaseApprovalServiceImpl.getAllDataOfPurchaseApproval();
			return ResponseDto.success("get All Data successfully", response);
		} catch (Exception errorException) {
			log.error("Exception error while getting the Data", errorException);
			return ResponseDto
					.failure("Exception occurred while getting the data of Purchase Approval" + errorException);

		}
	}
	
	@GetMapping("get/data/purchase/approval/employeeCode")
	@ApiOperation("get purchasing data by employee code")
	public ResponseDto<List<PurchaseApprovalEntity>> getDataPurchaseApprovalByEmployeecode(@RequestParam(name = "employeeCode") String employeeCode){
		try {
			log.info("purchase approval data {}",employeeCode);
			List<PurchaseApprovalEntity> response = purchaseApprovalServiceImpl.getDataByEmployeeCode(employeeCode);
			return ResponseDto.success("get Data successfully with employee code ",response);
			
		}catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data of Purchase Approval by employee code "+errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data of Purchase Approval by employee code "+errorMessage);
		}
	}
	
	@PutMapping("/update/hod")
	@ApiOperation("update details by hod")
	public ResponseDto<PurchaseApprovalByHODDto> updateDetailByHOD(@RequestParam(name = "approvalId") String approvalId, @RequestBody PurchaseApprovalByHODDto purchaseApprovalByHODDto ) {
		try {
			log.info("user {}", approvalId);
			PurchaseApprovalByHODDto response = purchaseApprovalServiceImpl.updatePurchasingApprovalByHOD(approvalId, purchaseApprovalByHODDto);
			return ResponseDto.success("purchase Approval details update successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while saving the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while updating the purchase Approval data " + errorMessage);
		}
	}
	
	@PutMapping("/update/cos")
	@ApiOperation("update details by COS")
	public ResponseDto<PurchaseApprovalByCOSDto> updateDetailByCOS(@RequestParam(name = "approvalId") String approvalId, @RequestBody PurchaseApprovalByCOSDto purchaseApprovalByCOSDto ) {
		try {
			log.info("user {}", approvalId);
			PurchaseApprovalByCOSDto response = purchaseApprovalServiceImpl.updatePurchasingApprovalByCOS(approvalId, purchaseApprovalByCOSDto);
			return ResponseDto.success("purchase Approval details update successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while saving the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while updating the purchase Approval data " + errorMessage);
		}
	}
	
}

