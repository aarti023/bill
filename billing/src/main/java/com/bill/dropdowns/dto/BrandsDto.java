package com.bill.dropdowns.dto;

import java.util.List;

import com.bill.dropdowns.SubBrandsEntity;

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
public class BrandsDto {

	private String brandsName;

//	private List<SubBrandsDto> subBrands;
}
