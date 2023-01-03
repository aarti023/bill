package com.bill.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bill.exception.FileNotFoundException;
import com.bill.exception.FileStorageException;
import com.bill.model.DatabaseFile;
import com.bill.repository.DatabaseFileRepository;
import com.bill.service.DatabaseFileService;

@Service
public class DatabaseFileServiceImpl implements DatabaseFileService {
	
	@Autowired
	private DatabaseFileRepository dbFileRepository;

	public DatabaseFile storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new com.bill.exception.FileStorageException(
						"Sorry! Filename contains invalid path sequence " + fileName);
			}

			DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

			return dbFileRepository.save(dbFile);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

//	 public DatabaseFile getFile(Long fileId) {
//	        return dbFileRepository.findById(fileId)
//	                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
//	    }
//	======================================================
	@Override
	public DatabaseFile save(MultipartFile file) {
		String docname = file.getOriginalFilename();
		try {
			DatabaseFile doc = new DatabaseFile(docname, file.getContentType(), file.getBytes()); 
			return dbFileRepository.save(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Optional<DatabaseFile> getFile(Long fieldId) {
		return dbFileRepository.findById(fieldId);
	}
	
	@Override
	public List<DatabaseFile> getFiles() {
		return dbFileRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
