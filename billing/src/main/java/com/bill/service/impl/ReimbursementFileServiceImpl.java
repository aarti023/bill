package com.bill.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bill.model.ProfileEntity;
import com.bill.model.ReimbursementEntity;
import com.bill.model.ReimbursementFileEntity;
import com.bill.repository.ReimbursementFileRepo;
import com.bill.service.ReimbursementFileService;

@Service
public class ReimbursementFileServiceImpl implements ReimbursementFileService{

	@Autowired
	private ReimbursementFileRepo reimbursementFileRepo;
	
	@Override
	public ReimbursementFileEntity save(MultipartFile multiPartFile, String employeeCode) {
		String fileName = multiPartFile.getOriginalFilename();
		String fileExtension = multiPartFile.getContentType();

		byte[] data = null;
		try {
			data = multiPartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		FileEntity fileToSave = new FileEntity(fileName, fileExtension, data, invoice);
		ReimbursementFileEntity reimburs = new ReimbursementFileEntity(employeeCode,fileName, fileExtension, data);
		return reimbursementFileRepo.save(reimburs);
	}

//	@Override
//	public Optional<ReimbursementFileEntity> findByEmployeeCode(String employeeCode) {
//		
//		return Optional.empty();
//	}

	
}
