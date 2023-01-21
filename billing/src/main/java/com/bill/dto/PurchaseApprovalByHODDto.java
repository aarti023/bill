package com.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseApprovalByHODDto {
	
	private String hodApproval;

	private String hodAapprovalDate;

	private String hodRemarks;
}
