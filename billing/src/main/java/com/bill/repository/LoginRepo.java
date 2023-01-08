package com.bill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.LoginEntity;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, Long> {

	public Optional<LoginEntity> findByEmail(String email);

	public Optional<LoginEntity> findOneByEmployeeCodeAndEmail(String employeeCode, String email);
	

}
