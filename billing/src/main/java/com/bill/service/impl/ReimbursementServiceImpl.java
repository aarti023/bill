package com.bill.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dto.ReimbursementDto;
import com.bill.model.LoginEntity;
import com.bill.model.ReimbursementEntity;
import com.bill.model.UserEntity;
import com.bill.repository.ReimbursementRepo;
import com.bill.service.ReimbursementService;

@Service
public class ReimbursementServiceImpl implements ReimbursementService{

	@Autowired
	private ReimbursementRepo reimbursementRepo;

	@Override
	public ReimbursementEntity saveReimbursement(ReimbursementDto reimbursementDto) {
		ReimbursementEntity reimburs = new ReimbursementEntity();
		LoginEntity login = new LoginEntity();
		reimburs.setReportingManagerId(login.getReportingManagerId());
		BeanUtils.copyProperties(reimbursementDto, reimburs);
		reimbursementRepo.save(reimburs);
		return reimburs;
	} 
	
	@Override
	public List<ReimbursementEntity> getReimbursementDataByEmployeeCode(String employeeCode) {
		List<ReimbursementEntity> reimburs = reimbursementRepo.findByEmployeeCode(employeeCode);
		return reimburs;
	}
}
