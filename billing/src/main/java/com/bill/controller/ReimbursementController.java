//package com.bill.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.bill.dto.PaymentUpdateDto;
//import com.bill.dto.PurchaseApprovalByCOSDto;
//import com.bill.dto.PurchaseApprovalByHODDto;
//import com.bill.dto.ReimbursementDto;
//import com.bill.dto.ResponseDto;
//import com.bill.model.ReimbursementEntity;
//import com.bill.model.UserEntity;
//import com.bill.service.FileService;
//import com.bill.service.ReimbursementService;
//
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.log4j.Log4j2;
//
//@RestController
//@RequestMapping("/reimbursement")
//@Log4j2
//public class ReimbursementController {
//
//	@Autowired
//	private ReimbursementService reimbursementService;
//	
//	@PostMapping("/save/reimbursement")
//	@ApiOperation("save reimbursement details")
//	public ResponseDto<ReimbursementEntity> saveReimbursement(@RequestBody ReimbursementDto reimbursementDto) {
//		try {
//			log.info(" reimbursement {}", reimbursementDto);
//			ReimbursementEntity response = reimbursementService.saveReimbursement(reimbursementDto);
//			return ResponseDto.success(" Reimbursement details saved successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while saving the  Reimbursement data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while saving the  Reimbursement data " + errorMessage);
//		}
//	}
//	
//	@GetMapping("/get/reimbursement/data/{employeeCode}")
//	@ApiOperation("get reimbursement detials by employee Code")
//	public ResponseDto<List<ReimbursementEntity>> getDetail(@PathVariable("employeeCode") String employeeCode) {
//		try {
//			log.info("reimbursement {}", employeeCode);
//			List<ReimbursementEntity> response = reimbursementService.getReimbursementDataByEmployeeCode(employeeCode);
//			return ResponseDto.success("Reimbursement details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the Reimbursement data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}
//	
//	@GetMapping("/get/reimbursement/")
//	@ApiOperation("get all reimbursement")
//	public ResponseDto<List<ReimbursementEntity>> getAllReimbursement() {
//		try {
//			log.info("reimbursement {}");
//			List<ReimbursementEntity> response = reimbursementService.getAllReimbursementDetails();
//			return ResponseDto.success("All Reimbursement details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}
//	
//	@PutMapping("/update/reimbursement/paymentStatus/{reimburseId}")
//	@ApiOperation("update reimbursement payment status")
//	public ResponseDto<PaymentUpdateDto> updateInvoiceStatus(@PathVariable("reimburseId") String reimburseId,
//			@RequestBody PaymentUpdateDto paymentUpdateDto) {
//		try {
//			log.info("reimbursement {}", reimburseId);
//			PaymentUpdateDto response = reimbursementService.updatePayement(reimburseId, paymentUpdateDto);
//			return ResponseDto.success("user details update successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while saving the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while updating the data " + errorMessage);
//		}
//	}
//	
//	@PutMapping("/update/reimbursement/hod")
//	@ApiOperation("update reimbursement details by hod")
//	public ResponseDto<PurchaseApprovalByHODDto> updateDetailByHOD(@RequestParam(name = "reimburseId") String reimburseId, @RequestBody PurchaseApprovalByHODDto purchaseApprovalByHODDto ) {
//		try {
//			log.info("reimbursement {}", reimburseId);
//			PurchaseApprovalByHODDto response = reimbursementService.updatePurchasingApprovalByHOD(reimburseId, purchaseApprovalByHODDto);
//			return ResponseDto.success("purchase Approval details update successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while saving the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while updating the purchase Approval data " + errorMessage);
//		}
//	}
//	
//	@PutMapping("/update/reimbursement/cos")
//	@ApiOperation("update reimbursement details by COS")
//	public ResponseDto<PurchaseApprovalByCOSDto> updateDetailByCOS(@RequestParam(name = "reimburseId") String reimburseId, @RequestBody PurchaseApprovalByCOSDto purchaseApprovalByCOSDto ) {
//		try {
//			log.info("user {}", reimburseId);
//			PurchaseApprovalByCOSDto response = reimbursementService.updatePurchasingApprovalByCOS(reimburseId, purchaseApprovalByCOSDto);
//			return ResponseDto.success("purchase Approval details update successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while saving the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while updating the purchase Approval data " + errorMessage);
//		}
//	}
//}
