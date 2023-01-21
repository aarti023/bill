package com.bill.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.bill.dto.ReimbursementDto;
import com.bill.model.ItemsEntity;
import com.bill.model.LoginEntity;
import com.bill.model.ReimbursementEntity;
import com.bill.repository.ReimbursementRepo;
import com.bill.service.ReimbursementService;

@Service
public class ReimbursementServiceImpl implements ReimbursementService{

	@Autowired
	private ReimbursementRepo reimbursementRepo;
	
	public String getGenrateUserId(String reimburseId) {

		if (Objects.nonNull(reimburseId)) {
			return reimburseId;
		}
		Random random1 = new Random(System.nanoTime() % 10000000);
		
		reimburseId = "RI" + String.format("%09d", random1.nextInt(10000000));
			
		return reimburseId;
	}
	
	@Override
	public ReimbursementEntity saveReimbursement(ReimbursementDto reimbursementDto) {
		ReimbursementEntity reimburs = new ReimbursementEntity();
		LoginEntity login = new LoginEntity();
		reimburs.setReportingManagerId(login.getReportingManagerId());
		reimbursementDto.setReimburseId(getGenrateUserId(reimbursementDto.getReimburseId()));
		
		BeanUtils.copyProperties(reimbursementDto, reimburs);
		reimbursementRepo.save(reimburs);
		return reimburs;
	}
	@Override
	public List<ReimbursementEntity> getAllReimbursementDetails() {
		if (Objects.isNull(ItemsEntity.class)) {

			throw new NotAcceptableStatusException("No reimbursement Found with this employee code ");
		}
		return reimbursementRepo.findAll();
	}
	
	@Override
	public List<ReimbursementEntity> getReimbursementDataByEmployeeCode(String employeeCode) {
		List<ReimbursementEntity> reimburs = reimbursementRepo.findByEmployeeCode(employeeCode);
		return reimburs;
	}
}
