package com.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

	File findByInvoiceNumber(String invoice);

}
