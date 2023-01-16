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

//	@Query(value="select u.employee_name, u.email from User u WHERE u.employee_code=?1", nativeQuery =true)
//	public UserEntity findByEmployeeCode(String employeeCode);

	public UserEntity findByInvoiceId(String invoiceId);

	public List<UserEntity> findByEmployeeCode(String employeeCode);

	public List<UserEntity> findByReportingManagerId(String reportingManagerId);
}
