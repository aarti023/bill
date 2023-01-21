package com.bill.service;

import java.util.List;

import com.bill.dto.PaymentUpdateDto;
import com.bill.dto.PurchaseApprovalByCOSDto;
import com.bill.dto.PurchaseApprovalByHODDto;
import com.bill.dto.ReimbursementDto;
import com.bill.model.ReimbursementEntity;

public interface ReimbursementService {

	ReimbursementEntity saveReimbursement(ReimbursementDto reimbursementDto);

	List<ReimbursementEntity> getReimbursementDataByEmployeeCode(String employeeCode);

	List<ReimbursementEntity> getAllReimbursementDetails();
	
	PaymentUpdateDto updatePayement(String approvalId, PaymentUpdateDto paymentUpdateDto);

	PurchaseApprovalByHODDto updatePurchasingApprovalByHOD(String reimburseId,
			PurchaseApprovalByHODDto purchaseApprovalByHODDto);

	PurchaseApprovalByCOSDto updatePurchasingApprovalByCOS(String approvalId,
			PurchaseApprovalByCOSDto purchaseApprovalByCOSDto);



}
