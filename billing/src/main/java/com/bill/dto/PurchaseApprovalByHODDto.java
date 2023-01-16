package com.bill.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseApprovalByHODDto {
	
	private String hodApproval;

	private Date hodAapprovalDate;

	private String hodRemarks;
}
