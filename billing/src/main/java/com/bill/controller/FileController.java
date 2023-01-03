package com.bill.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bill.dto.Response;
import com.bill.helper.FileUploadHelper;
import com.bill.model.DatabaseFile;
import com.bill.service.DatabaseFileService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/files")
@Log4j2
@CrossOrigin(origins = "*")
public class FileController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@Autowired
	private DatabaseFileService fileStorageService;

//	@PostMapping("/upload-file")
//	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		try {
//			if (file.isEmpty()) {
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
//
//			}
////			if (!file.getContentType().equals("image/jpeg")) {
////				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request only JPEJ file");
////
////			}
//			boolean f = fileUploadHelper.uploadFile(file);
//
//			if (f) {
//				return ResponseEntity.ok("File is successfuly saved");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Please try again");
//	}
//	====================test===============================

	@PostMapping("/uploadFile")
	public Response uploadFiles(@RequestParam("file") MultipartFile file) {
		DatabaseFile fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName.getFileName()).toUriString();

		return new Response(fileName.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
	}

//	@GetMapping("/downloadFile/{id}")
//	public ResponseEntity<Resource> downloadFile(@PathVariable Long id, HttpServletRequest request) {
//		DatabaseFile databaseFile = fileStorageService.getFile(id);
//
//		return ResponseEntity.ok().contentType(MediaType.parseMediaType(databaseFile.getFileType()))
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
//				.body(new ByteArrayResource(databaseFile.getData()));
//	}

//	    @PostMapping("/uploadMultipleFiles")
//	    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//	        return Arrays.asList(files)
//	                .stream()
//	                .map(file -> uploadFile(file))
//	                .collect(Collectors.toList());
//	    }
	
//	====================test===============================
	
//	@GetMapping("/")
//	public byte[] getFile(Model model) {
//		List<DatabaseFile> docs = fileStorageService.getFiles();
//		model.addAttribute("docs" + docs);
//		return docs.get(0).getData();
//	}
	
//	@PostMapping("uploadFile")
//	public String uploadFiles(@RequestParam ("file") MultipartFile[] files) {
//		for(MultipartFile  file:  files) {
//			fileStorageService.save(file);
//		}
//		return "redirect";
//	}
	
//	@GetMapping("/downloadFile/{fielId}")
//	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId){
//		DatabaseFile doc = fileStorageService.getFile(fileId).get();
//		return ResponseEntity.ok()
//				.contentType(MediaType.parseMediaType(doc.getFileType()))
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + doc.getFileName()+ "\"")
//				.body(new ByteArrayResource(doc.getData()));
//		
//	}
	
	
	
	
}
