package com.bill.wellserved.service;

import java.util.List;

import com.bill.wellserved.dto.WellServedDto;
import com.bill.wellserved.model.WellServedEntity;

public interface WellServedService {

	WellServedEntity saveCustomer(WellServedDto wellServedDto);

	List<WellServedEntity> getAllCustomerDetails();

}
