package com.bill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.ItemDto;
import com.bill.dto.ResponseDto;
import com.bill.model.ItemsEntity;
import com.bill.service.ItemService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
@RestController
@RequestMapping("/item")
@Log4j2
@CrossOrigin(origins = "*")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/save")
	@ApiOperation("save item details")
	public ResponseDto<ItemsEntity> saveDetail( @RequestBody ItemDto itemDto) {
		try {
			log.info("item {}", itemDto);
			ItemsEntity response = itemService.saveItem(itemDto);
			return ResponseDto.success("items saved successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while saving the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while saving the items " + errorMessage);
		}
	}
	
	@GetMapping("/get/{invoiceId}")
	@ApiOperation("get detials by id")
	public ResponseDto<List<ItemsEntity>> getDetailByInvoiceId(@PathVariable("invoiceId") String invoiceId) {
		try {
			log.info("user {}", invoiceId);
			List<ItemsEntity> response = itemService.findByInvoiceId(invoiceId);
			return ResponseDto.success("user details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
//	@GetMapping("/get/items/")
//	@ApiOperation("get all items")
//	public ResponseDto<List<ItemsEntity>> getAllItems() {
//		try {
//			log.info("item {}");
//			List<ItemsEntity> response = itemService.getAllItemDetails();
//			return ResponseDto.success("All User details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}
	
//	@GetMapping("/get/data/{invoiceNumber}")
//	@ApiOperation("get detials by id")
//	public ResponseDto<List<ItemsEntity>> getDetail(@PathVariable("invoiceNumber") String invoiceNumber) {
//		try {
//			log.info("user {}", invoiceNumber);
//			List<ItemsEntity> response = itemService.findByInvoiceNumber(invoiceNumber);
//			return ResponseDto.success("user details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}
	
}
