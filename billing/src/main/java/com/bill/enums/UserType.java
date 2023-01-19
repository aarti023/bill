package com.bill.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
	
	USER("user"),
	ADMIN("admin"),
	COS("chief of staff"),
	MANAGER("manager"),
	FINANCE("finance");
	
	public String name;
	
}
