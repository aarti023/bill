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
import com.bill.dropdowns.CategoriesEntity;
import com.bill.dropdowns.Departments;
import com.bill.dropdowns.ExpensesTypeEntity;
import com.bill.dropdowns.LocationsEntity;
import com.bill.dropdowns.SubBrandsEntity;
import com.bill.dropdowns.SubCategories1Entity;
import com.bill.dropdowns.SubCategories2Entity;
import com.bill.dropdowns.dto.BrandsDto;
import com.bill.dropdowns.dto.CategoriesDto;
import com.bill.dropdowns.dto.DepartmentsDto;
import com.bill.dropdowns.dto.ExpensesDto;
import com.bill.dropdowns.dto.LocationsDto;
import com.bill.dropdowns.dto.SubBrandsDto;
import com.bill.dropdowns.dto.SubCategories1Dto;
import com.bill.dropdowns.dto.SubCategories2Dto;
import com.bill.dropdowns.service.DropdownService;
import com.bill.dto.ResponseDto;
import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/dropdown")
@CrossOrigin(origins = "*")
public class DropdownController {

	@Autowired
	private DropdownService dropdownService;

//	@PostMapping(value = "/create")
//	@ApiOperation("create brands")
//	public ResponseDto<BrandsEntity> create(@RequestBody BrandsDto brandsDto) {
//
//		log.info("Create City [" + brandsDto + "]");
//
//		BrandsEntity response = brandsService.save(brandsDto);
//
//		return ResponseDto.success("City brands Successfully", response);
//
//	}

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
	
	@GetMapping("/get/department/")
	@ApiOperation("get all departments")
	public ResponseDto<List<Departments>> getDepartment() {
		try {
			log.info("user {}");
			List<Departments> response = dropdownService.getAllDepartments();
			return ResponseDto.success("All Departments get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
	@GetMapping("/get/expenses/")
	@ApiOperation("get all expenses")
	public ResponseDto<List<ExpensesTypeEntity>> getExpenses() {
		try {
			log.info("user {}");
			List<ExpensesTypeEntity> response = dropdownService.getAllExpenses();
			return ResponseDto.success("All Expenses get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
	@GetMapping("/get/location/")
	@ApiOperation("get all locations")
	public ResponseDto<List<LocationsEntity>> getLocations() {
		try {
			log.info("user {}");
			List<LocationsEntity> response = dropdownService.getAllLocations();
			return ResponseDto.success("All location get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	@GetMapping("/get/Brands/")
	@ApiOperation("get all Brands")
	public ResponseDto<List<BrandsEntity>> getAllBrands() {
		try {
			log.info("user {}");
			List<BrandsEntity> response = dropdownService.getAllBrands();
			return ResponseDto.success("All Brands get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
	@GetMapping("/get/subBrands/")
	@ApiOperation("get all Sub Brands")
	public ResponseDto<List<SubBrandsEntity>> getAllSubBrands() {
		try {
			log.info("user {}");
			List<SubBrandsEntity> response = dropdownService.getAllSubBrands();
			return ResponseDto.success("All subBrands get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
	@GetMapping("/get/category/")
	@ApiOperation("get all category")
	public ResponseDto<List<CategoriesEntity>> getAllCategory() {
		try {
			log.info("user {}");
			List<CategoriesEntity> response = dropdownService.getAllCategories();
			return ResponseDto.success("All category get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
	@GetMapping("/get/subCategory1/")
	@ApiOperation("get all subCategory1")
	public ResponseDto<List<SubCategories1Entity>> getAllSubCategory1() {
		try {
			log.info("user {}");
			List<SubCategories1Entity> response = dropdownService.getAllSubCategories1();
			return ResponseDto.success("All subCategory get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
	@GetMapping("/get/subCategory2/")
	@ApiOperation("get all subCategory2")
	public ResponseDto<List<SubCategories2Entity>> getAllSubCategory2() {
		try {
			log.info("user {}");
			List<SubCategories2Entity> response = dropdownService.getAllSubCategories2();
			return ResponseDto.success("All subCategory get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}
	
//	=======================SAVE APIS===================
	
	@PostMapping(value = "/brand")
	@ApiOperation("add brand")
	public ResponseDto<BrandsEntity> addBrand(@RequestBody BrandsDto brandsDto) {

		log.info("Add Brand [" + brandsDto + "]");

		BrandsEntity response = dropdownService.saveBrand(brandsDto);

		return ResponseDto.success("Brand Add Successfully", response);

	}
	
	@PostMapping(value = "/subBrand")
	@ApiOperation("add sub brand")
	public ResponseDto<SubBrandsEntity> addSubBrand(@RequestBody SubBrandsDto subBrandsDto) {

		log.info("Add Sub Brand [" + subBrandsDto + "]");

		SubBrandsEntity response = dropdownService.saveSubBrands(subBrandsDto);

		return ResponseDto.success("Sub Brand Add Successfully", response);

	}
	
	@PostMapping(value = "/location")
	@ApiOperation("add location")
	public ResponseDto<LocationsEntity> addLocation(@RequestBody LocationsDto locationsDto) {

		log.info("Add Location [" + locationsDto + "]");

		LocationsEntity response = dropdownService.saveLocation(locationsDto);

		return ResponseDto.success("Location Add Successfully", response);

	}
	
	@PostMapping(value = "/department")
	@ApiOperation("add department")
	public ResponseDto<Departments> addDepartment(@RequestBody DepartmentsDto departmentsDto) {

		log.info("Add Department [" + departmentsDto + "]");

		Departments response = dropdownService.saveDepartments(departmentsDto);

		return ResponseDto.success("Department Add Successfully", response);

	}
	
	@PostMapping(value = "/category")
	@ApiOperation("add category")
	public ResponseDto<CategoriesEntity> addCategory(@RequestBody CategoriesDto categoriesDto) {

		log.info("Add category [" + categoriesDto + "]");

		CategoriesEntity response = dropdownService.saveCategories(categoriesDto);

		return ResponseDto.success("category Add Successfully", response);

	}
	
	@PostMapping(value = "/subCategory1")
	@ApiOperation("add subCategory1")
	public ResponseDto<SubCategories1Entity> addSubCategory1(@RequestBody SubCategories1Dto subCategories1Dto) {

		log.info("Add subCategory1 [" + subCategories1Dto + "]");

		SubCategories1Entity response = dropdownService.saveSubCategories1(subCategories1Dto);

		return ResponseDto.success("subCategory1 Add Successfully", response);

	}
	
	@PostMapping(value = "/subCategory2")
	@ApiOperation("add subCategory2")
	public ResponseDto<SubCategories2Entity> addSubCategory2(@RequestBody SubCategories2Dto subCategories2Dto) {

		log.info("Add subCategory2 [" + subCategories2Dto + "]");

		SubCategories2Entity response = dropdownService.saveSubCategories2(subCategories2Dto);

		return ResponseDto.success("subCategory2 Add Successfully", response);

	}
	
	@PostMapping(value = "/expenses")
	@ApiOperation("add expenses")
	public ResponseDto<ExpensesTypeEntity> addExpenses(@RequestBody ExpensesDto expensesDto) {

		log.info("Add expenses [" + expensesDto + "]");

		ExpensesTypeEntity response = dropdownService.saveExpenses(expensesDto);

		return ResponseDto.success("expenses Add Successfully", response);

	}
		
	
}
