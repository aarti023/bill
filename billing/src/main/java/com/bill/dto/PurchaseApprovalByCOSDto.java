package com.bill.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseApprovalByCOSDto {

	private String finalApproval;

	private String finalApprovalDate;

	private String finalRemarks;
}
