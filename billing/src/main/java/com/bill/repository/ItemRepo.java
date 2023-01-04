package com.bill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bill.model.ItemsEntity;

public interface ItemRepo extends JpaRepository<ItemsEntity, Long> {
	
	public List<ItemsEntity> findByInvoiceNumber(String invoiceNumber);

	public List<ItemsEntity> findByInvoiceId(String invoiceId);
}
