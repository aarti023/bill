package com.bill.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.bill.dto.UserDto;
import com.bill.enums.UserType;
import com.bill.exception.ResourceNotFoundException;
import com.bill.model.UserEntity;
import com.bill.repository.UserRepo;
import com.bill.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;


	@Override
	public UserEntity saveUser(UserDto userDto) {
		userDto.setInvoiceId(getGenrateUserId(userDto.getUserType(), userDto.getInvoiceId()));
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(userDto, user);
		userRepo.save(user);
		return user;
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

}
