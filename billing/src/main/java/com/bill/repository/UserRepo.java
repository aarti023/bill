package com.bill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill.enums.UserType;
import com.bill.model.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

	public List<UserEntity> findByInvoiceNumber(String invoiceNumber);

	long countByUserType(UserType userType);

	@Query(value="select u.employee_name, u.email from User u WHERE u.employee_id=?1", nativeQuery =true)
//	public UserEntity findByEmployeeId(String employeeId);
	public String findByEmployeeId(String employeeId);

}
