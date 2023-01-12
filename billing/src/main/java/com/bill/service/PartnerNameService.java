package com.bill.service;

import com.bill.dto.PartnerNameDto;
import com.bill.model.PartnerNameEntity;

public interface PartnerNameService {

	PartnerNameEntity savePartnerName (PartnerNameDto partnerNameDto);
}
