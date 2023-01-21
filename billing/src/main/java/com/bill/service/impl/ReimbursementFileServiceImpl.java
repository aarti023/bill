package com.bill.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bill.model.ProfileEntity;
import com.bill.model.ReimbursementFileEntity;
import com.bill.repository.ReimbursementFileRepo;
import com.bill.service.ReimbursementFileService;

@Service
public class ReimbursementFileServiceImpl implements ReimbursementFileService{

	@Autowired
	private ReimbursementFileRepo reimbursementFileRepo;
	
	
	@Override
	public ReimbursementFileEntity save(MultipartFile multiPartFile, String reimburseId, String employeeCode) {
		String fileName = multiPartFile.getOriginalFilename();
		String fileExtension = multiPartFile.getContentType();
		
		byte[] data = null;
		
		try {
			data = multiPartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		ReimbursementFileEntity reimburs = new ReimbursementFileEntity(fileExtension, fileName, fileExtension, reimburseId, data);
//		ReimbursementFileEntity reimburs = new ReimbursementFileEntity(fileName, fileExtension,data,reimburseId);
		ReimbursementFileEntity reimburs = new ReimbursementFileEntity(reimburseId, fileName, fileExtension,employeeCode , data);
		return reimbursementFileRepo.save(reimburs);
	}
		
}
