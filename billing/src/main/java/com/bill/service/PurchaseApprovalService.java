package com.bill.service;

import java.util.List;

import com.bill.dto.PaymentUpdateDto;
import com.bill.dto.PurchaseApprovalByCOSDto;
import com.bill.dto.PurchaseApprovalByHODDto;
import com.bill.dto.PurchaseApprovalDto;
import com.bill.dto.UserUpdateDto;
import com.bill.enums.UserType;
import com.bill.model.PurchaseApprovalEntity;

public interface PurchaseApprovalService {

	PurchaseApprovalEntity savePurchase(PurchaseApprovalDto purchaseApprovalDto);

	List<PurchaseApprovalEntity> getAllDataOfPurchaseApproval();

	List<PurchaseApprovalEntity> getDataByEmployeeCode(String employeeCode);


//	String getGenrateUserId(String approvalId);

	PurchaseApprovalByCOSDto updatePurchasingApprovalByCOS(String approvalId,
			PurchaseApprovalByCOSDto purchaseApprovalByCOSDto);

	PurchaseApprovalByHODDto updatePurchasingApprovalByHOD(String approvalId,
			PurchaseApprovalByHODDto purchaseApprovalByHODDto);

	List<PurchaseApprovalEntity> getAprovalDataReportingManagerId(String reportingManagerId);

	String getGenrateUserId(UserType userType, String id);

	PaymentUpdateDto updatePayement(String approvalId, PaymentUpdateDto paymentUpdateDto);

}
