package com.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.PartnerNameDto;
import com.bill.dto.ResponseDto;
import com.bill.model.PartnerNameEntity;
import com.bill.service.PartnerNameService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/partners")
@Log4j2
@CrossOrigin(origins = "*")
public class PartnerNameController {

	@Autowired
	private PartnerNameService partnerNameService;

	@PostMapping(value = "/partner/name")
	@ApiOperation("add partner name")
	public ResponseDto<PartnerNameEntity> savePartnerName(@RequestBody PartnerNameDto partnerNameDto) {

		log.info("dropdown of adding expenseType {} [" + partnerNameDto + "]");

		PartnerNameEntity response = partnerNameService.savePartnerName(partnerNameDto);

		return ResponseDto.success("partner name Add Successfully", response);

	}

}
