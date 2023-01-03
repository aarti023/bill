package com.bill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.bill.model.DatabaseFile;

public interface DatabaseFileService {
	
//	public DatabaseFile getFile(Long fileId);
//
	public DatabaseFile storeFile(MultipartFile file);
	
	public DatabaseFile save(MultipartFile file) ;
	
	public Optional<DatabaseFile> getFile(Long fieldId);
	
	public List<DatabaseFile> getFiles();
}
