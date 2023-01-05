package com.bill.service;

import java.util.List;

import com.bill.dto.ItemDto;
import com.bill.model.ItemsEntity;

public interface ItemService {
	ItemsEntity saveItem(ItemDto itemDto);

	List<ItemsEntity> getAllItemDetails();

	List<ItemsEntity> findByInvoiceNumber(String invoiceNumber);

	List<ItemsEntity> findByInvoiceId(String invoiceId);

}
