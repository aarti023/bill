package com.bill.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	boolean save(MultipartFile file);

}
