package com.bill.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dto.PartnerNameDto;
import com.bill.model.PartnerNameEntity;
import com.bill.repository.PartnerNameRepo;
import com.bill.service.PartnerNameService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PartnerNameServiceImpl implements PartnerNameService {
	
	@Autowired
	private PartnerNameRepo partnerRepo;

	@Override
	public PartnerNameEntity savePartnerName(PartnerNameDto partnerNameDto) {
		PartnerNameEntity name = new PartnerNameEntity();
		BeanUtils.copyProperties(partnerNameDto, name);

		partnerRepo.save(name);
		log.info("Add partner name with this  id: " + name.getId());

		return name;
	}

	
}
