package com.bill.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
	
	ADMIN("admin"),
	USER("user");
	
	public String name;
	
}
