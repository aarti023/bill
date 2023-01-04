package com.bill.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bill.exception.FileStorageException;
import com.bill.model.File;
import com.bill.repository.FileRepository;
import com.bill.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileRepository dbFileRepository;

	@Override
	public File save(MultipartFile file, String invoice) {
		String fileName = file.getOriginalFilename();
		String fileExtension = file.getContentType();
		byte[] data = null;
		try {
			data = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fileToSave = new File(fileName,fileExtension,data,invoice);
		return dbFileRepository.save(fileToSave);
	}
	
	@Override
	public Optional<File> getFile(String invoice) {
		File file = dbFileRepository.findByInvoiceNumber(invoice);
		if(Objects.nonNull(file)) {
			if(file.getFileType().equalsIgnoreCase("image/png")) {
			      ByteArrayInputStream bis = new ByteArrayInputStream(file.getData());
			      BufferedImage bImage2 = null;
				try {
					bImage2 = ImageIO.read(bis);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      try {
			    	  java.io.File files = new java.io.File("C:\\Users\\aarti\\OneDrive\\Desktop\\output.png");
					ImageIO.write(bImage2, "jpg",files);
					try (FileOutputStream fosFor = new FileOutputStream(files)) {
			            fosFor.write(file.getData());
			        }


			      } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
