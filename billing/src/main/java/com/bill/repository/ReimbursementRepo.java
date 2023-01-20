package com.bill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.ReimbursementEntity;

@Repository
public interface ReimbursementRepo extends JpaRepository<ReimbursementEntity,Long> {

	List<ReimbursementEntity> findByEmployeeCode(String employeeCode);

}
