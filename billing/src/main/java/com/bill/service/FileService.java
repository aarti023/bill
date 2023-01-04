package com.bill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.bill.model.FileEntity;

public interface FileService {
	
	public FileEntity save(MultipartFile file, String invoiceNumber) ;
	
	public Optional<FileEntity> getFile(String  invoiceNumber);
	
	public List<FileEntity> getAllFile();
}
