package com.bill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.PurchaseApprovalEntity;

@Repository
public interface PurchaseApprovalRepo extends JpaRepository<PurchaseApprovalEntity, Long>{

	List<PurchaseApprovalEntity> findByEmployeeCode(String employeeCode);

	PurchaseApprovalEntity findByApprovalId(String approvalId);

	List<PurchaseApprovalEntity> findByReportingManagerId(String reportingManagerId);

}
