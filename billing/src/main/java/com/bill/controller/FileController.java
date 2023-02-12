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
import com.bill.repository.FileRepository;
import com.bill.service.FileService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/files")
@Log4j2
public class FileController {

	@Autowired
	private FileService fileStorageService;
	
	@Autowired
	private FileRepository fileRepo;

	
	@PostMapping("/upload/file")
	public String uploadFilesInDB(@RequestParam(value = "file") MultipartFile multiPartFile,
			@RequestParam(name = "invoiceId") String invoiceId) {

		fileStorageService.save(multiPartFile, invoiceId);
		return "File stored successfully";
	}

	@GetMapping("get/all/files")
	public MultipartFile getFiles() {
		fileStorageService.getAllFile();
		return null;
	}
	
	@GetMapping("get/file/")
	public ResponseEntity<byte[]> getFileByInvoiceId(@RequestParam(name = "invoiceId") String invoiceId) {
		Optional<FileEntity> fileEntity = fileRepo.findByInvoiceId(invoiceId);
		log.info("file {}", fileEntity.get().getFileType());
		String ft = fileEntity.get().getFileType();
		byte[] files = null;
		if(fileEntity.isPresent()) {
			files = fileEntity.get().getData();
		}
		if(ft.equals("image/jpeg") || ft.equals("image/jpg")) {
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
