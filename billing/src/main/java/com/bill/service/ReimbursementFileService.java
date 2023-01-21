package com.bill.service;

import org.springframework.web.multipart.MultipartFile;

import com.bill.model.ReimbursementFileEntity;

public interface ReimbursementFileService {

	ReimbursementFileEntity save(MultipartFile multiPartFile, String invoiceId, String employeeCode);

}
