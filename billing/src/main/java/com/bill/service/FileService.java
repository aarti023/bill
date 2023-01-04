package com.bill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.bill.model.File;

public interface FileService {
	
	public File save(MultipartFile file, String invoiceNumber) ;
	
	public Optional<File> getFile(String  invoiceNumber);
}
