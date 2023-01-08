package com.bill.dropdowns.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsDto {
	private String departmentName;

//	private List<CategoriesEntity> categories;
//
//	private List<SubCategories1Entity> subCategories;
}
