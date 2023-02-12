package com.bill.dropdowns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dropdowns.BrandsEntity;
import com.bill.dropdowns.ExpensesTypeEntity;
import com.bill.dropdowns.ItemsNameCodeEntity;
import com.bill.dropdowns.PartnerNameAndCodeEntity;
import com.bill.dropdowns.dto.BrandsDto;
import com.bill.dropdowns.dto.ExpensesDto;
import com.bill.dropdowns.dto.ItemsNameCodeDto;
import com.bill.dropdowns.dto.PartnerNameCodeDto;
import com.bill.dropdowns.service.DropdownService;
import com.bill.dto.ResponseDto;
import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/dropdown")
public class DropdownController {

	@Autowired
	private DropdownService dropdownService;

	@GetMapping("/get/expenseType/")
	@ApiOperation("get all expenses type")
	public ResponseDto<List<ExpensesTypeEntity>> getExpenseType() {
		try {
			log.info("dropdown of getting expenseType {}");
			List<ExpensesTypeEntity> response = dropdownService.getAllExpenseType();
			return ResponseDto.success("All Expenses get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}

//	@PostMapping(value = "/expenseType")
//	@ApiOperation("add expenses")
//	public ResponseDto<ExpensesTypeEntity> saveExpenseType(@RequestBody ExpensesDto expensesDto) {
//
//		log.info("dropdown of adding expenseType {} [" + expensesDto + "]");
//
//		ExpensesTypeEntity response = dropdownService.saveExpenseType(expensesDto);
//
//		return ResponseDto.success("expenses Add Successfully", response);
//
//	}
	
	@GetMapping("/get/items/")
	@ApiOperation("get all items code and name")
	public ResponseDto<List<ItemsNameCodeEntity>> getItems() {
		try {
			log.info("dropdown of getting expenseType {}");
			List<ItemsNameCodeEntity> response = dropdownService.getItems();
			return ResponseDto.success("All Expenses get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}

	@PostMapping(value = "/items")
	@ApiOperation("add items code and name")
	public ResponseDto<ItemsNameCodeEntity> saveItems(@RequestBody ItemsNameCodeDto itemsDto) {

		log.info("dropdown of adding items {} [" + itemsDto + "]");

		ItemsNameCodeEntity response = dropdownService.saveItems(itemsDto);

		return ResponseDto.success("expenses Add Successfully", response);

	}
	
	@GetMapping("/get/partners/")
	@ApiOperation("get all partner anme and code")
	public ResponseDto<List<PartnerNameAndCodeEntity>> getPartnersNameCode() {
		try {
			log.info("dropdown of getting expenseType {}");
			List<PartnerNameAndCodeEntity> response = dropdownService.getPartnerNameAndCode();
			return ResponseDto.success("All partner name and code get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the partner anme and code " + errorMessage);
		}
	}

	@PostMapping(value = "/partners")
	@ApiOperation("add partners name and code")
	public ResponseDto<PartnerNameAndCodeEntity> savePartnersNameCode(@RequestBody PartnerNameCodeDto partnerNameAndCodeDto) {

		log.info("dropdown of adding partner name and code {} [" + partnerNameAndCodeDto + "]");

		PartnerNameAndCodeEntity response = dropdownService.addPartnerNameCode(partnerNameAndCodeDto);

		return ResponseDto.success(" Add partner name and codeSuccessfully", response);

	}

	@PostMapping(value = "/brand")
	@ApiOperation("add brands and subbrands")
	public ResponseDto<BrandsEntity> saveBrand(@RequestBody BrandsDto brandsDto) {

		log.info("create brand with subBrand [" + brandsDto + "]");

		BrandsEntity response = dropdownService.saveBrand(brandsDto);
		return ResponseDto.success(" brands Successfully", response);

	}
	@GetMapping(value = "/getSubBrand/{brandName}")
	public List<String> getBrand(@PathVariable("brandName")String brand) {

		log.info("get details [" + brand + "]");

		List<String> response = dropdownService.getSubBrand(brand);

//	return ResponseDto.success("save details Successfully", response);
		return response;

	}
	
	@PostMapping(value = "/save/brand/subBrand")
	@ApiOperation("save brand according to sub brands")
	public ResponseDto<List<BrandsEntity>> saveSubBrandWithBrand(@RequestBody List<BrandsEntity> brandsEntity) {

		log.info("Save details [" + brandsEntity + "]");

		List<BrandsEntity> response = dropdownService.saveSubBrandWithBrand(brandsEntity);
		Gson gson = new Gson();
		String json = gson.toJson(response);
   	return ResponseDto.success("save details Successfully", response);
//		return json;
	}
	
//	@PostMapping(value = "/saveAll")
//	@ApiOperation("save subbrand according to brand name")
//	public String saveAll(@RequestBody List<BrandsEntity> brands) {
//
//		log.info("Save details [" + brands + "]");
//
//		List<BrandsEntity> response = dropdownService.saveAll(brands);
//		Gson gson = new Gson();
//		String json = gson.toJson(response);
////	return ResponseDto.success("save details Successfully", response);
//		return json;
//
//	}

//	@GetMapping(value = "/getSubBrand/{brandName}")
//	public List<String> getSubBrand(@PathVariable("brandName") String brand) {
//
//		log.info("get details [" + brand + "]");
//
//		List<String> response = dropdownService.getSubBrand(brand);
//
////	return ResponseDto.success("save details Successfully", response);
//		return response;
//
//	}	

//	@GetMapping("/get/brands/")
//	@ApiOperation("get all brands")
//	public ResponseDto<List<BrandsEntity>> getBrands() {
//		try {
//			log.info("user {}");
//			List<BrandsEntity> response = dropdownService.getAllBrands();
//			return ResponseDto.success("All Brands get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//
//	}
//	...........................CATEGORY......................

//	@PostMapping(value = "/saveCatagories")
//	@ApiOperation("save catagories and subCatagories according to department name")
//	public String saveAllCategories(@RequestBody List<Departments> departments) {
//
//		log.info("Save details [" + departments + "]");
//
//		List<Departments> response = dropdownService.saveAllCategories(departments);
//		Gson gson = new Gson();
//		String json = gson.toJson(response);
////	return ResponseDto.success("save details Successfully", response);
//		return json;
//
//	}

//	@GetMapping(value = "/getCatagories/{departmentName}")
//	public List<String> getCatagories(@PathVariable("departmentName") String department) {
//
//		log.info("get details [" + department + "]");
//
//		List<String> response = dropdownService.getCatagories(department);
//
////	return ResponseDto.success("save details Successfully", response);
//		return response;
//
//	}

//	@GetMapping(value = "/getSubCatagories/{departmentName}")
//	public List<String> getSubCatagories(@PathVariable("departmentName") String department) {
//
//		log.info("get details [" + department + "]");
//
//		List<String> response = dropdownService.getSubCatagories(department);
//
////	return ResponseDto.success("save details Successfully", response);
//		return response;
//
//	}

//	@GetMapping("/get/department/")
//	@ApiOperation("get all departments")
//	public ResponseDto<List<Departments>> getDepartment() {
//		try {
//			log.info("user {}");
//			List<Departments> response = dropdownService.getAllDepartments();
//			return ResponseDto.success("All Departments get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

//	@GetMapping("/get/location/")
//	@ApiOperation("get all locations")
//	public ResponseDto<List<LocationsEntity>> getLocations() {
//		try {
//			log.info("user {}");
//			List<LocationsEntity> response = dropdownService.getAllLocations();
//			return ResponseDto.success("All location get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}/

//	@GetMapping("/get/Brands/")
//	@ApiOperation("get all Brands")
//	public ResponseDto<List<BrandsEntity>> getAllBrands() {
//		try {
//			log.info("user {}");
//			List<BrandsEntity> response = dropdownService.getAllBrands();
//			return ResponseDto.success("All Brands get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

//	@GetMapping("/get/subBrands/")
//	@ApiOperation("get all Sub Brands")
//	public ResponseDto<List<SubBrandsEntity>> getAllSubBrands() {
//		try {
//			log.info("user {}");
//			List<SubBrandsEntity> response = dropdownService.getAllSubBrands();
//			return ResponseDto.success("All subBrands get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

//	@GetMapping("/get/category/")
//	@ApiOperation("get all category")
//	public ResponseDto<List<CategoriesEntity>> getAllCategory() {
//		try {
//			log.info("user {}");
//			List<CategoriesEntity> response = dropdownService.getAllCategories();
//			return ResponseDto.success("All category get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

//	@GetMapping("/get/subCategory1/")
//	@ApiOperation("get all subCategory1")
//	public ResponseDto<List<SubCategories1Entity>> getAllSubCategory1() {
//		try {
//			log.info("user {}");
//			List<SubCategories1Entity> response = dropdownService.getAllSubCategories1();
//			return ResponseDto.success("All subCategory get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

//	@GetMapping("/get/subCategory2/")
//	@ApiOperation("get all subCategory2")
//	public ResponseDto<List<SubCategories2Entity>> getAllSubCategory2() {
//		try {
//			log.info("user {}");
//			List<SubCategories2Entity> response = dropdownService.getAllSubCategories2();
//			return ResponseDto.success("All subCategory get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

//	=======================SAVE APIS===================

//	@PostMapping(value = "/brand")
//	@ApiOperation("add brand")
//	public ResponseDto<BrandsEntity> addBrand(@RequestBody BrandsDto brandsDto) {
//
//		log.info("Add Brand [" + brandsDto + "]");
//
//		BrandsEntity response = dropdownService.saveBrand(brandsDto);
//
//		return ResponseDto.success("Brand Add Successfully", response);
//
//	}

//	@PostMapping(value = "/subBrand")
//	@ApiOperation("add sub brand")
//	public ResponseDto<SubBrandsEntity> addSubBrand(@RequestBody SubBrandsDto subBrandsDto) {
//
//		log.info("Add Sub Brand [" + subBrandsDto + "]");
//
//		SubBrandsEntity response = dropdownService.saveSubBrands(subBrandsDto);
//
//		return ResponseDto.success("Sub Brand Add Successfully", response);
//
//	}

//	@PostMapping(value = "/location")
//	@ApiOperation("add location")
//	public ResponseDto<LocationsEntity> addLocation(@RequestBody LocationsDto locationsDto) {
//
//		log.info("Add Location [" + locationsDto + "]");
//
//		LocationsEntity response = dropdownService.saveLocation(locationsDto);
//
//		return ResponseDto.success("Location Add Successfully", response);
//
//	}

//	@PostMapping(value = "/department")
//	@ApiOperation("add department")
//	public ResponseDto<Departments> addDepartment(@RequestBody DepartmentsDto departmentsDto) {
//
//		log.info("Add Department [" + departmentsDto + "]");
//
//		Departments response = dropdownService.saveDepartments(departmentsDto);
//
//		return ResponseDto.success("Department Add Successfully", response);
//
//	}

//	@PostMapping(value = "/category")
//	@ApiOperation("add category")
//	public ResponseDto<CategoriesEntity> addCategory(@RequestBody CategoriesDto categoriesDto) {
//
//		log.info("Add category [" + categoriesDto + "]");
//
//		CategoriesEntity response = dropdownService.saveCategories(categoriesDto);
//
//		return ResponseDto.success("category Add Successfully", response);
//
//	}

//	@PostMapping(value = "/subCategory1")
//	@ApiOperation("add subCategory1")
//	public ResponseDto<SubCategories1Entity> addSubCategory1(@RequestBody SubCategories1Dto subCategories1Dto) {
//
//		log.info("Add subCategory1 [" + subCategories1Dto + "]");
//
//		SubCategories1Entity response = dropdownService.saveSubCategories1(subCategories1Dto);
//
//		return ResponseDto.success("subCategory1 Add Successfully", response);
//
//	}

//	@PostMapping(value = "/subCategory2")
//	@ApiOperation("add subCategory2")
//	public ResponseDto<SubCategories2Entity> addSubCategory2(@RequestBody SubCategories2Dto subCategories2Dto) {
//
//		log.info("Add subCategory2 [" + subCategories2Dto + "]");
//
//		SubCategories2Entity response = dropdownService.saveSubCategories2(subCategories2Dto);
//
//		return ResponseDto.success("subCategory2 Add Successfully", response);
//
//	}

}
