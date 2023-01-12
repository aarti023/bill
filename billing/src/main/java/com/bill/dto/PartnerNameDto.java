package com.bill.dto;

import com.bill.model.PartnerCodeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerNameDto {
	
	private String partnerName;
	
	private PartnerCodeEntity partnerCode;
}
