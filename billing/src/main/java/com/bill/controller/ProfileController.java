package com.bill.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bill.model.FileEntity;
import com.bill.model.ProfileEntity;
import com.bill.repository.ProfileRepository;
import com.bill.service.ProfileService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/profile")
@Log4j2
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private ProfileRepository profileRepo;

	@PostMapping("/upload/profile")
	public String uploadFilesInDB(@RequestParam(value = "file") MultipartFile multiPartFile,
			@RequestParam(name = "employeeCode") String employeeCode) {

		profileService.saveProfile(multiPartFile, employeeCode);
		return "Profile stored successfully";
	}

	
	@GetMapping("get/profile/")
	public ResponseEntity<byte[]> getProfileByEmployeeCode(@RequestParam(name = "employeeCode") String employeeCode) {
		Optional<ProfileEntity> profile = profileRepo.getProfileByEmployeeCode(employeeCode);
		log.info("file {}", profile.get().getFileType());
		String fileType = profile.get().getFileType();
		byte[] files = null;
		if(profile.isPresent()) {
			files = profile.get().getData();
		}
		if(fileType.equals("image/jpeg")) {
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(files); 
		}
		else if(fileType.equals("image/png")) {
			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(files);
		}
		else {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(files);
		}
//		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(files);
	}
}
