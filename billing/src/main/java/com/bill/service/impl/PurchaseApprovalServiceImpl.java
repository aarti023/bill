package com.bill.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.bill.dto.PurchaseApprovalByCOSDto;
import com.bill.dto.PurchaseApprovalByHODDto;
import com.bill.dto.PurchaseApprovalDto;
import com.bill.model.LoginEntity;
import com.bill.model.PurchaseApprovalEntity;
import com.bill.model.RelationsEntity;
import com.bill.model.UserEntity;
import com.bill.repository.PurchaseApprovalRepo;
import com.bill.service.PurchaseApprovalService;

@Service
public class PurchaseApprovalServiceImpl implements PurchaseApprovalService {

	@Autowired
	private PurchaseApprovalRepo purchaseApprovalRepo;
	
	@Override
	public String getGenrateUserId(String approvalId) {

		if (Objects.nonNull(approvalId)) {
			return approvalId;
		}

		Random random1 = new Random(System.nanoTime() % 10000000);
		
		approvalId = "AP" + String.format("%09d", random1.nextInt(10000000));
			
		return approvalId;
	}

	@Override
	public PurchaseApprovalEntity savePurchase(PurchaseApprovalDto purchaseApprovalDto) {
		PurchaseApprovalEntity approvalEntity = new PurchaseApprovalEntity();
		LoginEntity login = new LoginEntity();
		approvalEntity.setReportingManagerId(login.getReportingManagerId());
		purchaseApprovalDto.setApprovalId(getGenrateUserId(purchaseApprovalDto.getApprovalId()));
		BeanUtils.copyProperties(purchaseApprovalDto, approvalEntity);
		purchaseApprovalRepo.save(approvalEntity);
		return approvalEntity;
	}

	@Override
	public List<PurchaseApprovalEntity> getAllDataOfPurchaseApproval() {
		if (Objects.isNull(PurchaseApprovalEntity.class)) {
			throw new NotAcceptableStatusException("Approvals not found");
		}
		return purchaseApprovalRepo.findAll();
	}

	@Override
	public List<PurchaseApprovalEntity> getDataByEmployeeCode(String employeeCode) {
		List<PurchaseApprovalEntity> approval = purchaseApprovalRepo.findByEmployeeCode(employeeCode);
		return approval;
	}

	@Override
	public PurchaseApprovalByHODDto updatePurchasingApprovalByHOD(String approvalId, PurchaseApprovalByHODDto purchaseApprovalByHODDto) {
		PurchaseApprovalEntity approval = purchaseApprovalRepo.findByApprovalId(approvalId);
		approval.setHodAapprovalDate(purchaseApprovalByHODDto.getHodAapprovalDate());
		approval.setHodApproval(purchaseApprovalByHODDto.getHodApproval());
		approval.setHodRemarks(purchaseApprovalByHODDto.getHodRemarks());
		purchaseApprovalRepo.save(approval);
		return purchaseApprovalByHODDto;
	}
	
	@Override
	public PurchaseApprovalByCOSDto updatePurchasingApprovalByCOS(String approvalId, PurchaseApprovalByCOSDto purchaseApprovalByCOSDto) {
		PurchaseApprovalEntity approval = purchaseApprovalRepo.findByApprovalId(approvalId);
		approval.setFinalApprovalDate(purchaseApprovalByCOSDto.getFinalApprovalDate());
		approval.setFinalApproval(purchaseApprovalByCOSDto.getFinalApproval());
		approval.setFinalRemarks(purchaseApprovalByCOSDto.getFinalRemarks());
		purchaseApprovalRepo.save(approval);
		return purchaseApprovalByCOSDto;
	}
	
	@Override
	public List<PurchaseApprovalEntity> getAprovalDataReportingManagerId(String reportingManagerId) {
		List<PurchaseApprovalEntity> approval = purchaseApprovalRepo.findByReportingManagerId(reportingManagerId);
		return approval;
	}
}
