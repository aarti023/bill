package com.bill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.enums.UserType;
import com.bill.model.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

	public List<UserEntity> findByInvoiceNumber(String invoiceNumber);

	long countByUserType(UserType userType);

}
