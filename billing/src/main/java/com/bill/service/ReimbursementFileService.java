package com.bill.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.bill.model.ReimbursementFileEntity;

public interface ReimbursementFileService {

	ReimbursementFileEntity save(MultipartFile multiPartFile, String invoiceId);

//	Optional<ReimbursementFileEntity> findByEmployeeCode(String employeeCode);

}
