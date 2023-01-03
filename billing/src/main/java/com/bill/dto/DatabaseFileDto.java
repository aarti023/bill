package com.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseFileDto {
	
	private String invoiceNumber;

	private String fileName;
	
	private byte[] data;

}
