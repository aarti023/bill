package com.bill.dropdowns.service;

import java.util.List;

import com.bill.dropdowns.BrandsEntity;
import com.bill.dropdowns.CategoriesEntity;
import com.bill.dropdowns.Departments;
import com.bill.dropdowns.ExpensesTypeEntity;
import com.bill.dropdowns.ItemsEntity;
import com.bill.dropdowns.LocationsEntity;
import com.bill.dropdowns.PartnerNameAndCodeEntity;
import com.bill.dropdowns.SubBrandsEntity;
import com.bill.dropdowns.SubCategories1Entity;
import com.bill.dropdowns.SubCategories2Entity;
import com.bill.dropdowns.dto.BrandsDto;
import com.bill.dropdowns.dto.CategoriesDto;
import com.bill.dropdowns.dto.DepartmentsDto;
import com.bill.dropdowns.dto.ExpensesDto;
import com.bill.dropdowns.dto.ItemsDto;
import com.bill.dropdowns.dto.LocationsDto;
import com.bill.dropdowns.dto.PartnerNameCodeDto;
import com.bill.dropdowns.dto.SubBrandsDto;
import com.bill.dropdowns.dto.SubCategories1Dto;
import com.bill.dropdowns.dto.SubCategories2Dto;

public interface DropdownService {
	
//	public BrandsEntity save(BrandsDto brandsDto);
//	
//	public List<BrandsEntity> saveAll(List<BrandsEntity> brandsEntity);
//	
//	public List<String> getSubBrand(String brand);

//	.............................CATAGORY.....................................
	
//	public List<Departments> saveAllCategories(List<Departments> departments);
//
//	public List<String> getCatagories(String department);
//
//	List<String> getSubCatagories(String department);
	
	List<PartnerNameAndCodeEntity> getPartnerNameAndCode();
	
	List<ItemsEntity> getItems();
	
	List<BrandsEntity> getAllBrands();

	List<SubBrandsEntity> getAllSubBrands();
	
	List<ExpensesTypeEntity> getAllExpenseType();
	
	List<Departments> getAllDepartments();
	
	List<LocationsEntity> getAllLocations();
	
	List<CategoriesEntity> getAllCategories();
	
	List<SubCategories1Entity> getAllSubCategories1();
	
	List<SubCategories2Entity> getAllSubCategories2();
	
	BrandsEntity saveBrand(BrandsDto brandsDto);
	
	SubBrandsEntity saveSubBrands(SubBrandsDto subBrandsDto);
	
	LocationsEntity saveLocation(LocationsDto locationDto);
	
	Departments saveDepartments(DepartmentsDto departmentsDto);
	
    CategoriesEntity saveCategories(CategoriesDto categoriesDto);
    
    SubCategories1Entity saveSubCategories1(SubCategories1Dto subCategories1Dto);
	
    SubCategories2Entity saveSubCategories2(SubCategories2Dto subCategories2Dto);
    
    ExpensesTypeEntity saveExpenseType (ExpensesDto expensesDto);
    
    public List<String> getSubBrand(String Brands);
    
    public List<BrandsEntity> saveSubBrandWithBrand(List<BrandsEntity> brandEntity);
	
	ItemsEntity saveItems(ItemsDto itemsDto);
	
	PartnerNameAndCodeEntity addPartnerNameCode(PartnerNameCodeDto partnerNameCodeDto);

	
	
}
