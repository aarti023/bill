package com.bill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.RelationsEntity;
import com.bill.model.UserEntity;
//import com.google.common.base.Optional;

@Repository
public interface RelationsRepo  extends JpaRepository<RelationsEntity,Long> {

	Optional<RelationsEntity> findOneByEmployeeCodeAndPassword(String employeeCode, String password);
//	public UserEntity find

	Optional<RelationsEntity> findOneByEmployeeCodeAndEmail(String email, String employeeCode);

//	RelationsEntity findByEmployeeCode();

}
