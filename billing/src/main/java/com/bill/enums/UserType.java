package com.bill.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
	
	USER("user"),
	ADMIN("admin");
	
	public String name;
	
}
