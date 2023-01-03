package com.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.UserEntity;

@Repository
public interface UserRepo extends  JpaRepository<UserEntity, Long>{

	public UserEntity findByInvoiceNumber(String invoiceNumber);
}
