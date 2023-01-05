package com.bill.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.bill.dto.EmployeeCodeDto;
import com.bill.dto.MergeAllTableDto;
import com.bill.dto.UserDto;
import com.bill.dto.UserUpdateDto;
import com.bill.enums.UserType;
import com.bill.exception.ResourceNotFoundException;
import com.bill.model.ItemsEntity;
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

//	@Autowired
//	private FileRepository fileRepo;
	
	public UserEntity saveUser(UserDto userDto) {
		userDto.setInvoiceId(getGenrateUserId(userDto.getUserType(), userDto.getInvoiceId()));
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(userDto, user);
		userRepo.save(user);
		return user;
	}
	

	@Override
	public EmployeeCodeDto getNameAndEmailByEmployeeCode(String employeeCode) {
		UserEntity user = userRepo.findByEmployeeCode(employeeCode);
		EmployeeCodeDto employeeCodeDto = new EmployeeCodeDto();
		employeeCodeDto.setEmail(user.getEmail());
		employeeCodeDto.setEmployeeName(user.getEmployeeName());
		
		return employeeCodeDto;

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
			id = "P" + String.format("%09d", random1.nextInt(10000000));
			break;

		default:
			id = null;
			break;
		}
		return id;
	}

	@Override
	public List<MergeAllTableDto> getAll() {
		System.out.println("enity");
		List<ItemsEntity> items = itemRepo.findAll();
		List<UserEntity> users = userRepo.findAll();
//		List<FileEntity> files = fileRepo.findAll();
		List<MergeAllTableDto> merge = new ArrayList<>();
		for (ItemsEntity item : items) {
			MergeAllTableDto dto = new MergeAllTableDto();
			for (UserEntity user : users) {
//				for (FileEntity file : files) {
				if (item.getInvoiceNumber().equals(user.getInvoiceNumber())) {

					dto.setId(item.getId());
					dto.setEmployeeCode(user.getEmployeeCode());
					dto.setEmployeeName(user.getEmployeeName());
					dto.setInvoiceNumber(user.getInvoiceNumber());
					dto.setInvoiceDate(user.getInvoiceDate());
					dto.setInvoiceDescription(user.getInvoiceDescription());
					dto.setEmail(user.getEmail());
					dto.setBrand(user.getBrand());
					dto.setSubBrand(user.getSubBrand());
					dto.setLocation(user.getLocation());
					dto.setDepartment(user.getDepartment());
					dto.setCategory(user.getCategory());
					dto.setSubCatagory1(user.getSubCatagory1());
					dto.setSubCatagory2(user.getSubCatagory2());
					dto.setPreTaxAmount(user.getPreTaxAmount());
					dto.setTotalAmount(user.getTotalAmount());
					dto.setGstAmount(user.getGstAmount());
					dto.setPaymentMethod(user.getPaymentMethod());
					dto.setPaymentMode(user.getPaymentMode());
					dto.setExpensesType(user.getExpensesType());
					dto.setPayDirectCard(user.getPayDirectCard());
					dto.setExpensesCategory(user.getExpensesCategory());
					dto.setPartnerCode(user.getPartnerCode());
					dto.setPartnerName(user.getPartnerName());
					dto.setInvoiceDescription(user.getInvoiceDescription());
					dto.setServiceCategory(user.getServiceCategory());
					dto.setInvoiceId(user.getInvoiceId());
					dto.setUserType(user.getUserType());
					dto.setPaymentCycle(user.getPaymentCycle());
					dto.setReportingManager(user.getReportingManager());
					dto.setTaskId(user.getTaskId());
					dto.setUtr(user.getUtr());

					dto.setDateOfInvoice(item.getDateOfInvoice());
					dto.setItemName(item.getItemName());
					dto.setItemCode(item.getItemCode());
					dto.setCategoryItem(item.getCategoryItem());
					dto.setUnit(item.getUnit());
					dto.setQuantity(item.getQuantity());
					dto.setRate(item.getRate());
					dto.setAmount(item.getAmount());
					dto.setGstAmountItem(item.getGstAmountItem());
					dto.setDiscount(item.getDiscount());
					dto.setAmountPaid(item.getAmountPaid());
					dto.setRedeemed(item.getRedeemed());
					dto.setCgst(item.getCgst());
					dto.setIgst(item.getIgst());
					dto.setSgst(item.getSgst());
					dto.setTds(item.getTds());
					dto.setTdsAmount(item.getTdsAmount());

//						dto.setFileName(file.getFileName());

				}

			}
//			}

			merge.add(dto);
		}

		return merge;

	}


	@Override
	public UserUpdateDto updateUser(String invoiceId, UserUpdateDto userUpdateDto) {
		UserEntity user = userRepo.findByInvoiceId(invoiceId);
		user.setPaidAmount(userUpdateDto.getPaidAmount());
		user.setPaymentStatus(userUpdateDto.getPaymentStatus());
		user.setPaymentDate(userUpdateDto.getPaymentDate());
		user.setTransactionDetail(userUpdateDto.getTransactionDetail());
		userRepo.save(user);
		return userUpdateDto;
		
	}
	
}
