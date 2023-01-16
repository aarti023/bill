package com.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.PurchaseApprovalEntity;

@Repository
public interface PurchaseApprovalRepo extends JpaRepository<PurchaseApprovalEntity, Long>{

}
