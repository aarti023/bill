package com.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReimbursementFileDto {
	
	private String fileName;

	private String invoiceId;

	private byte[] data;
}
