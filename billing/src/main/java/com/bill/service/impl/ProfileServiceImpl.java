package com.bill.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bill.model.ProfileEntity;
import com.bill.repository.ProfileRepository;
import com.bill.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public ProfileEntity saveProfile(MultipartFile multiPartFile, String employeeCode) {
		String fileName = multiPartFile.getOriginalFilename();
		String fileExtension = multiPartFile.getContentType();

		byte[] data = null;
		try {
			data = multiPartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		FileEntity fileToSave = new FileEntity(fileName, fileExtension, data, invoice);
		ProfileEntity profile = new ProfileEntity(employeeCode,fileName, fileExtension, data);
		return profileRepository.save(profile);
	}

}
