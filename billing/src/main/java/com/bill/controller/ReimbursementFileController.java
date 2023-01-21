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
import com.bill.model.ReimbursementFileEntity;
import com.bill.repository.ReimbursementFileRepo;
import com.bill.service.ReimbursementFileService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/reimbursement")
@Log4j2
@CrossOrigin(origins = "*")
public class ReimbursementFileController {
	
	@Autowired
	private ReimbursementFileService reimbursementFileService;
	
	@Autowired
	private ReimbursementFileRepo reimbursementFileRepo;
	
	@PostMapping("/upload/file")
	public String uploadFilesInDB(@RequestParam(value = "file") MultipartFile multiPartFile,
			@RequestParam(name = "employeeCode") String employeeCode, String reimburseId) {

		reimbursementFileService.save(multiPartFile, employeeCode, reimburseId);
		return "File stored successfully";
	}
	
//	@GetMapping("get/file/")
//	public ResponseEntity<byte[]> getFileByEmployeeCode(@RequestParam(name = "employeeCode") String employeeCode) {
//		Optional<ReimbursementFileEntity> fileEntity = reimbursementFileRepo.findByEmployeeCode(employeeCode);
//		log.info("file {}", fileEntity.get().getFileType());
//		String ft = fileEntity.get().getFileType();
//		byte[] files = null;
//		if(fileEntity.isPresent()) {
//			files = fileEntity.get().getData();
//		}
//		if(ft.equals("image/jpeg")) {
//			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(files); 
//		}
//		else if(ft.equals("image/png")) {
//			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(files);
//		}
//		else {
//			return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(files);
//		}
//	}
	
	
	@GetMapping("get/file/")
	public ResponseEntity<byte[]> getFileByReimbursementId(@RequestParam(name = "reimburseId") String reimburseId) {
		Optional<ReimbursementFileEntity> fileEntity = reimbursementFileRepo.findByReimburseId(reimburseId);
		log.info("file {}", fileEntity.get().getFileType());
		String ft = fileEntity.get().getFileType();
		byte[] files = null;
		if(fileEntity.isPresent()) {
			files = fileEntity.get().getData();
		}
		if(ft.equals("image/jpeg")) {
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(files); 
		}
		else if(ft.equals("image/png")) {
			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(files);
		}
		else {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(files);
		}
//		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(files);
	}
}
