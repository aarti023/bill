package com.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
	
	private String paidAmount;

	private String paymentDate;

	private String paymentStatus;

	private String transactionDetail;
	
}
