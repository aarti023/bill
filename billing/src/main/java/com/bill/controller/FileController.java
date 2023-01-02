package com.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bill.helper.FileUploadHelper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class FileController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");

			}
//			if (!file.getContentType().equals("image/jpeg")) {
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request only JPEJ file");
//
//			}
			boolean f =fileUploadHelper.uploadFile(file);
			
			if(f) {
				return ResponseEntity.ok("File is successfuly saved");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Please try again");
	}
}
