package com.bill.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.bill.dto.PurchaseApprovalDto;
import com.bill.model.PurchaseApprovalEntity;
import com.bill.repository.PurchaseApprovalRepo;
import com.bill.service.PurchaseApprovalService;

@Service
public class PurchaseApprovalServiceImpl implements PurchaseApprovalService{

	@Autowired
	private PurchaseApprovalRepo purchaseApprovalRepo;

	@Override
	public PurchaseApprovalEntity savePurchase(PurchaseApprovalDto purchaseApprovalDto) {
		PurchaseApprovalEntity approvalEntity = new PurchaseApprovalEntity();
		BeanUtils.copyProperties(purchaseApprovalDto, approvalEntity);
		purchaseApprovalRepo.save(approvalEntity);
		return approvalEntity;
	}
	
	@Override
	public List<PurchaseApprovalEntity> getAllDataOfPurchaseApproval() {
		if(Objects.isNull(PurchaseApprovalEntity.class)) {
			throw new NotAcceptableStatusException("Approvals not found");
		}
		return purchaseApprovalRepo.findAll();
	}
}
