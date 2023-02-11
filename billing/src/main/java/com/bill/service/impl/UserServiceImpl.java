package com.bill.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.bill.dto.EmployeeCodeDto;
import com.bill.dto.InvoiceStatusUpdateDto;
import com.bill.dto.UserDto;
import com.bill.dto.UserUpdateDto;
import com.bill.enums.UserType;
import com.bill.exception.ResourceNotFoundException;
import com.bill.model.LoginEntity;
import com.bill.model.UserEntity;
import com.bill.repository.ItemRepo;
import com.bill.repository.UserRepo;
import com.bill.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ItemRepo itemRepo;

	public UserEntity saveUser(UserDto userDto) {
		userDto.setInvoiceId(getGenrateUserId(userDto.getUserType(), userDto.getInvoiceId()));
		LoginEntity login = new LoginEntity();
		UserEntity user = new UserEntity();
		user.setReportingManagerId(login.getReportingManagerId());
		BeanUtils.copyProperties(userDto, user);
		userRepo.save(user);
		return user;
	}

	@Override
	public EmployeeCodeDto getNameAndEmailByEmployeeCode(String employeeCode) {
//		UserEntity user = userRepo.findByEmployeeCode(employeeCode);
//		EmployeeCodeDto employeeCodeDto = new EmployeeCodeDto();
//		employeeCodeDto.setEmail(user.getEmail());
//		employeeCodeDto.setEmployeeName(user.getEmployeeName());
//		employeeCodeDto.setReportingManager(user.getReportingManager());
//		
//		return employeeCodeDto;
		return null;

	}

	@Override
	public List<UserEntity> getAllUserDetails() {
		if (Objects.isNull(UserEntity.class)) {

			throw new NotAcceptableStatusException("User Not Found with id: ");
		}
		return userRepo.findAll();
	}

	@Override
	public UserEntity getSavedDataById(Long id) {
		Optional<UserEntity> user = userRepo.findById(id);

		if (Objects.isNull(user)) {

			throw new NotAcceptableStatusException("User Not Found with id: " + id);
		}

		log.info("User Found: " + user);

		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	}

	@Override
	public List<UserEntity> findByInvoiceNumber(String invoiceNumber) {
		List<UserEntity> user = userRepo.findByInvoiceNumber(invoiceNumber);
		return user;
	}

	@Override
	public String getGenrateUserId(UserType userType, String id) {

		if (Objects.nonNull(id)) {
			return id;
		}

		Random random1 = new Random(System.nanoTime() % 10000000);
		switch (userType) {

		case ADMIN:
			id = "A" + String.format("%09d", random1.nextInt(10000000));
			break;

		case USER:
			id = "U" + String.format("%09d", random1.nextInt(10000000));
			break;

		case MANAGER:
			id = "RM" + String.format("%09d", random1.nextInt(10000000));
			break;

		case FINANCE:
			id = "F" + String.format("%09d", random1.nextInt(10000000));
			break;

		case COS:
			id = "COS" + String.format("%09d", random1.nextInt(10000000));
			break;
		default:
			id = null;
			break;
		}
		return id;
	}

	@Override
	public UserUpdateDto updateUser(String invoiceId, UserUpdateDto userUpdateDto) {
		UserEntity user = userRepo.findByInvoiceId(invoiceId);
		user.setPaidAmount(userUpdateDto.getPaidAmount());
		user.setUpdatePaymentStatus(userUpdateDto.getUpdatePaymentStatus());
		user.setReimbursementDate(userUpdateDto.getReimbursementDate());
		user.setTransactionDetail(userUpdateDto.getTransactionDetail());
		user.setPaymentStatus(userUpdateDto.getPaymentStatus());
		userRepo.save(user);
		return userUpdateDto;

	}

	@Override
	public InvoiceStatusUpdateDto updateInvoiceStatus(String invoiceId, InvoiceStatusUpdateDto invoiceStatusUpdateDto) {
		UserEntity user = userRepo.findByInvoiceId(invoiceId);
		user.setInvoiceStatus(invoiceStatusUpdateDto.getInvoiceStatus());
		userRepo.save(user);
		return invoiceStatusUpdateDto;
	}

	@Override
	public List<UserEntity> getDataByEmployeeCode(String employeeCode) {
		List<UserEntity> user = userRepo.findByEmployeeCode(employeeCode);
		return user;
	}

	@Override
	public List<UserEntity> getDataReportingManagerId(String reportingManagerId) {
		List<UserEntity> user = userRepo.findByReportingManagerId(reportingManagerId);
		return user;
	}

	@Override
	public List<UserEntity> getDetailsByName(String employeeName, UserEntity userEntity) {
		
		return null;
	}

}
