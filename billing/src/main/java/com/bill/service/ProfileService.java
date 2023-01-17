package com.bill.service;

import org.springframework.web.multipart.MultipartFile;

import com.bill.model.ProfileEntity;

public interface ProfileService {

	public ProfileEntity saveProfile(MultipartFile multiPartFile, String employeeCode);

}
