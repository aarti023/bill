package com.bill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
