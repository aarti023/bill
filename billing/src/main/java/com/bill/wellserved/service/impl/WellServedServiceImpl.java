package com.bill.wellserved.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.bill.wellserved.dto.WellServedDto;
import com.bill.wellserved.model.WellServedEntity;
import com.bill.wellserved.repository.WellServedRepo;
import com.bill.wellserved.service.WellServedService;

@Service
public class WellServedServiceImpl implements WellServedService {

	@Autowired
	private WellServedRepo wellServedRepo;

	@Override
	public WellServedEntity saveCustomer(WellServedDto wellServedDto) {
		WellServedEntity wellServed = new WellServedEntity();
		BeanUtils.copyProperties(wellServedDto, wellServed);
		wellServedRepo.save(wellServed);
		return wellServed;
	}

	@Override
	public List<WellServedEntity> getAllCustomerDetails() {
		if (Objects.isNull(WellServedEntity.class)) {

			throw new NotAcceptableStatusException("Customer Not Found with id: ");
		}
		return wellServedRepo.findAll();
	}

}
