package com.bill.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bill.model.FileEntity;
import com.bill.repository.FileRepository;
import com.bill.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository dbFileRepository;

	@Override
	public FileEntity save(MultipartFile file, String invoice) {
		String fileName = file.getOriginalFilename();
		String fileExtension = file.getContentType();
		byte[] data = null;
		try {
			data = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileEntity fileToSave = new FileEntity(fileName, fileExtension, data, invoice);
		return dbFileRepository.save(fileToSave);
	}

	@Override
	public Optional<FileEntity> getFile(String invoiceId) {
		FileEntity file = dbFileRepository.findByInvoiceId(invoiceId);
		if (Objects.nonNull(file)) {
			if (file.getFileType().equalsIgnoreCase("image/png")) {
				ByteArrayInputStream bis = new ByteArrayInputStream(file.getData());
				BufferedImage bImage2 = null;
				try {
					bImage2 = ImageIO.read(bis);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					java.io.File files = new java.io.File("C:\\Users\\aarti\\OneDrive\\Desktop\\img\\output.png");
					ImageIO.write(bImage2, "jpg", files);
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

	@Override
	public List<FileEntity> getAllFile() {
		List<FileEntity> files = dbFileRepository.findAll();
		if (Objects.nonNull(files)) {
			int count = 1;
			for (FileEntity file : files) {
				if (file.getFileType().equalsIgnoreCase("image/png")) {
					ByteArrayInputStream bis = new ByteArrayInputStream(file.getData());
					BufferedImage bImage2 = null;
					try {
						bImage2 = ImageIO.read(bis);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						java.io.File files1 = new java.io.File(
								"C:\\Users\\aarti\\OneDrive\\Desktop\\img\\output" + count + ".png");
						count++;
						ImageIO.write(bImage2, "jpg", files1);
						try (FileOutputStream fosFor = new FileOutputStream(files1)) {
							fosFor.write(file.getData());
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return null;
	}

	@Override
	public Optional<FileEntity> getFileByInvoiceNumber(String invoiceNumber) {
		FileEntity file = dbFileRepository.findByInvoiceNumber(invoiceNumber);
		if (Objects.nonNull(file)) {
			if (file.getFileType().equalsIgnoreCase("image/png")) {
				ByteArrayInputStream bis = new ByteArrayInputStream(file.getData());
				BufferedImage bImage2 = null;
				try {
					bImage2 = ImageIO.read(bis);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					java.io.File files = new java.io.File("C:\\Users\\aarti\\OneDrive\\Desktop\\img\\output.png");
					ImageIO.write(bImage2, "jpg", files);
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
