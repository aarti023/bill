package com.bill.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.bill.dto.ItemDto;
import com.bill.model.ItemsEntity;
import com.bill.repository.ItemRepo;
import com.bill.service.ItemService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;

	@Override
	public ItemsEntity saveItem(ItemDto itemDto) {
		ItemsEntity item = new ItemsEntity();
		BeanUtils.copyProperties(itemDto, item);
		itemRepo.save(item);
		return item;
	}

	@Override
	public List<ItemsEntity> getAllItemDetails() {
		if (Objects.isNull(ItemsEntity.class)) {

			throw new NotAcceptableStatusException("Item Not Found with this invoice number: ");
		}
		return itemRepo.findAll();
	}

	@Override
	public List<ItemsEntity> findByInvoiceNumber(String invoiceNumber) {
		List<ItemsEntity> items = itemRepo.findByInvoiceNumber(invoiceNumber);		
		return items;
	}
	
	@Override
	public List<ItemsEntity> findByInvoiceId(String invoiceId) {
		List<ItemsEntity> items = itemRepo.findByInvoiceId(invoiceId);		
		return items;
	}

}