package com.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bill.service.FileService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/files")
@Log4j2
@CrossOrigin(origins = "*")
public class FileController {

	@Autowired
	private FileService fileStorageService;

	@PostMapping("/upload/file")
	public String uploadFilesInDB(@RequestParam(name = "file") MultipartFile multiPartFile,
			@RequestParam(name = "invoiceNumber") String invoiceNumber) {

		fileStorageService.save(multiPartFile, invoiceNumber);
		return "File stored successfully";
	}
	
	@GetMapping("get/file")
	public MultipartFile getFileByInvoice(@RequestParam(name = "invoiceNumber") String invoiceNumber) {
		fileStorageService.getFile(invoiceNumber);
		return null;
	}
	
	@GetMapping("get/all/files")
	public MultipartFile getFiles() {
		fileStorageService.getAllFile();
		return null;
	}
}
