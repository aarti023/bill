package com.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

	FileEntity findByInvoiceNumber(String invoice);
	
	FileEntity findByInvoiceId(String invoice);

}
