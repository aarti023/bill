package com.bill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.ReimbursementFileEntity;

@Repository
public interface ReimbursementFileRepo extends JpaRepository<ReimbursementFileEntity, Long>{

	Optional<ReimbursementFileEntity> findByEmployeeCode(String employeeCode);

	Optional<ReimbursementFileEntity> findByReimburseId(String reimbursementId);

}
