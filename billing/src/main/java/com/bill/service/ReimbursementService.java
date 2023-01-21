package com.bill.service;

import java.util.List;

import com.bill.dto.ReimbursementDto;
import com.bill.model.ReimbursementEntity;

public interface ReimbursementService {

	ReimbursementEntity saveReimbursement(ReimbursementDto reimbursementDto);

	List<ReimbursementEntity> getReimbursementDataByEmployeeCode(String employeeCode);

	List<ReimbursementEntity> getAllReimbursementDetails();


}
