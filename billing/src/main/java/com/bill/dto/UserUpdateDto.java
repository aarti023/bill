package com.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
	
	private String paidAmount;

	private String reimbursementDate;

	private String updatePaymentStatus;

	private String transactionDetail;
	
	private String paymentStatus;
	
	
}
