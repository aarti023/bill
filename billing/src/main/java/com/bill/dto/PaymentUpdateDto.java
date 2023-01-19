package com.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentUpdateDto {
	
	private String paidAmount;

	private String reimbursementPaymentDate;

	private String paymentStatus;

	private String transactionDetail;
}
