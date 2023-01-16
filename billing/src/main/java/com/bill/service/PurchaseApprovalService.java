package com.bill.service;

import java.util.List;

import com.bill.dto.PurchaseApprovalDto;
import com.bill.model.PurchaseApprovalEntity;

public interface PurchaseApprovalService {

	PurchaseApprovalEntity savePurchase(PurchaseApprovalDto purchaseApprovalDto);

	List<PurchaseApprovalEntity> getAllDataOfPurchaseApproval();

}
