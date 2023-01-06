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


//	@PostMapping("/upload/file")
//	public String uploadFilesInDB(@RequestParam(name = "file") MultipartFile multiPartFile,
//			@RequestParam(name = "invoiceId") String invoiceId,
//			@RequestParam(name = "invoiceNumber") String invoiceNumber) {
//
//		fileStorageService.save(multiPartFile, invoiceId,invoiceNumber);
//		return "File stored successfully";
//	}
	
	@PostMapping("/upload/file")
	public String uploadFilesInDB(@RequestParam(value = "file") MultipartFile multiPartFile,
			@RequestParam(name = "invoiceId") String invoiceId) {

		fileStorageService.save(multiPartFile, invoiceId);
		return "File stored successfully";
	}
	
	@GetMapping("get/file/")
	public MultipartFile getFileByInvoiceId(@RequestParam(name = "invoiceId") String invoiceId) {
		fileStorageService.getFile(invoiceId);
		return null;
	}
	
//	@GetMapping("get/files/number")
//	public MultipartFile getFileByInvoiceNumber(@RequestParam(name = "invoiceNumber") String invoiceNumber) {
//		fileStorageService.getFileByInvoiceNumber(invoiceNumber);
//		return null;
//	}
	
	@GetMapping("get/all/files")
	public MultipartFile getFiles() {
		fileStorageService.getAllFile();
		return null;
	}
}
