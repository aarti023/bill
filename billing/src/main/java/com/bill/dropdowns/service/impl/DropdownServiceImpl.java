package com.bill.dropdowns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dropdowns.BrandsEntity;
import com.bill.dropdowns.CategoriesEntity;
import com.bill.dropdowns.Departments;
import com.bill.dropdowns.ExpensesTypeEntity;
import com.bill.dropdowns.ItemsNameCodeEntity;
import com.bill.dropdowns.LocationsEntity;
import com.bill.dropdowns.PartnerNameAndCodeEntity;
import com.bill.dropdowns.SubBrandsEntity;
import com.bill.dropdowns.SubCategories1Entity;
import com.bill.dropdowns.SubCategories2Entity;
import com.bill.dropdowns.dto.BrandsDto;
import com.bill.dropdowns.dto.CategoriesDto;
import com.bill.dropdowns.dto.DepartmentsDto;
import com.bill.dropdowns.dto.ExpensesDto;
import com.bill.dropdowns.dto.ItemsNameCodeDto;
import com.bill.dropdowns.dto.LocationsDto;
import com.bill.dropdowns.dto.PartnerNameCodeDto;
import com.bill.dropdowns.dto.SubBrandsDto;
import com.bill.dropdowns.dto.SubCategories1Dto;
import com.bill.dropdowns.dto.SubCategories2Dto;
import com.bill.dropdowns.repository.BrandsRepo;
import com.bill.dropdowns.repository.CategoriesRepo;
import com.bill.dropdowns.repository.DepartmentRepo;
import com.bill.dropdowns.repository.ExpensesRepo;
import com.bill.dropdowns.repository.ItemsRepo;
import com.bill.dropdowns.repository.LocationRepo;
import com.bill.dropdowns.repository.PartnerNameCodeRepo;
import com.bill.dropdowns.repository.SubBrandRepo;
import com.bill.dropdowns.repository.SubCategories1Repo;
import com.bill.dropdowns.repository.SubCategories2Repo;
import com.bill.dropdowns.service.DropdownService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DropdownServiceImpl implements DropdownService {

	@Autowired
	private BrandsRepo brandsRepo;

	@Autowired
	private SubBrandRepo SubBrandsRepo;

	@Autowired
	private CategoriesRepo categoriesRepo;

	@Autowired
	private SubCategories1Repo subCategories1Repo;

	@Autowired
	private SubCategories2Repo subCategories2Repo;

	@Autowired
	private LocationRepo locationRepo;

	@Autowired
	private ExpensesRepo expensesRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private SubBrandRepo subBrandRepo;
	
	@Autowired
	private ItemsRepo itemsRepo;
	
	@Autowired
	private PartnerNameCodeRepo partnerNameCodeRepo;

	@Override
	public List<BrandsEntity> getAllBrands() {
		return brandsRepo.findAll();
	}

	@Override
	public List<ExpensesTypeEntity> getAllExpenseType() {
		return expensesRepo.findAll();

	}

	@Override
	public List<Departments> getAllDepartments() {
		return departmentRepo.findAll();
	}

	@Override
	public List<SubBrandsEntity> getAllSubBrands() {
		return SubBrandsRepo.findAll();
	}

	@Override
	public List<LocationsEntity> getAllLocations() {
		return locationRepo.findAll();
	}

	@Override
	public List<CategoriesEntity> getAllCategories() {
		return categoriesRepo.findAll();
	}

	@Override
	public List<SubCategories1Entity> getAllSubCategories1() {
		return subCategories1Repo.findAll();
	}

	@Override
	public List<SubCategories2Entity> getAllSubCategories2() {
		return subCategories2Repo.findAll();
	}
	
	@Override
	public List<ItemsNameCodeEntity> getItems() {
		return itemsRepo.findAll();
	}
	
	@Override
	public List<PartnerNameAndCodeEntity> getPartnerNameAndCode() {
		return partnerNameCodeRepo.findAll();
	}
	

	@Override
	public PartnerNameAndCodeEntity addPartnerNameCode(PartnerNameCodeDto partnerNameCodeDto) {
		PartnerNameAndCodeEntity partner = new PartnerNameAndCodeEntity();
		BeanUtils.copyProperties(partnerNameCodeDto, partner);

		partnerNameCodeRepo.save(partner);
		log.info("Add partner name and code with this  id: " + partner.getId());

		return partner;
	}

	@Override
	public BrandsEntity saveBrand(BrandsDto brandsDto) {
		BrandsEntity brand = new BrandsEntity();
		BeanUtils.copyProperties(brandsDto, brand);

		brandsRepo.save(brand);
		log.info("Add brand with this  id: " + brand.getId());

		return brand;
	}

	@Override
	public SubBrandsEntity saveSubBrands(SubBrandsDto subBrandsDto) {
		
		SubBrandsEntity subBrand = new SubBrandsEntity();
		BeanUtils.copyProperties(subBrandsDto, subBrand);

		subBrandRepo.save(subBrand);
		log.info("Add subBrand with this  id: " + subBrand.getId());

		return subBrand;
	}

	@Override
	public LocationsEntity saveLocation(LocationsDto locationDto) {
		LocationsEntity location = new LocationsEntity();
		BeanUtils.copyProperties(locationDto, location);

		locationRepo.save(location);
		log.info("Add location with this  id: " + location.getId());

		return location;
	}

	@Override
	public Departments saveDepartments(DepartmentsDto departmentsDto) {
		Departments department = new Departments();
		BeanUtils.copyProperties(departmentsDto, department);

		departmentRepo.save(department);
		log.info("Add department with this  id: " + department.getId());

		return department;
	}

	@Override
	public CategoriesEntity saveCategories(CategoriesDto categoriesDto) {
		CategoriesEntity categories = new CategoriesEntity();
		BeanUtils.copyProperties(categoriesDto, categories);

		categoriesRepo.save(categories);
		log.info("Add categories with this  id: " + categories.getId());

		return categories;
	}

	@Override
	public SubCategories1Entity saveSubCategories1(SubCategories1Dto subCategories1Dto) {
		SubCategories1Entity subCategories1 = new SubCategories1Entity();
		BeanUtils.copyProperties(subCategories1Dto, subCategories1);

		subCategories1Repo.save(subCategories1);
		log.info("Add subCategories with this  id: " + subCategories1.getId());

		return subCategories1;
	}

	@Override
	public SubCategories2Entity saveSubCategories2(SubCategories2Dto subCategories2Dto) {
		SubCategories2Entity subCategories2 = new SubCategories2Entity();
		BeanUtils.copyProperties(subCategories2Dto, subCategories2);

		subCategories2Repo.save(subCategories2);
		log.info("Add subCategories with this  id: " + subCategories2.getId());

		return subCategories2;
	}

	@Override
	public ExpensesTypeEntity saveExpenseType(ExpensesDto expensesDto) {
		ExpensesTypeEntity expenses = new ExpensesTypeEntity();
		BeanUtils.copyProperties(expensesDto, expenses);

		expensesRepo.save(expenses);
		log.info("Add department with this  id: " + expenses.getId());

		return expenses;
	}
//	@Override
//	public BrandsEntity save(BrandsDto brandsDto) {
//		BrandsEntity brands = new BrandsEntity();
//		BeanUtils.copyProperties(brandsDto, brands);
//
//		brandsRepo.save(brands);
//		log.info("Created brand with this  id: " + brands.getId());
//		return brands;
//	}

	

//	@Override
//	public List<BrandsEntity> saveAll(List<BrandsEntity> brandsEntity) {
//		brandsRepo.saveAll(brandsEntity);
//		return brandsEntity;
//
//	}

//	@Override
//	public List<String> getSubBrand(String brand) {
//		List<BrandsEntity> brands = brandsRepo.findBybrandsName(brand);
//		List<String> list = new ArrayList<>();
//		brands.stream().forEach(s ->s.getSubBrands().stream().forEach(c -> list.add(c.getSubBrandsName())));
//		return list;
//		
//	}

//	..................................DEPARTMENT.....................................

//	@Override
//	public List<Departments> saveAllCategories(List<Departments> departments) {
//		departmentRepo.saveAll(departments);
//		return departments;
//	}
//
//	@Override
//	public List<String> getSubCatagories(String department) {
//		List<Departments> departments = departmentRepo.findByDepartmentName(department);
//		List<String> list = new ArrayList<>();
//		departments.stream().forEach(a -> a.getSubCategories().stream().forEach(b -> list.add(b.getSubCategories1Name())));
//		return list;
//	}
//	
//	@Override
//	public List<String> getCatagories(String department) {
//		List<Departments> departments = departmentRepo.findByDepartmentName(department);
//		List<String> list = new ArrayList<>();
//		departments.stream().forEach(s ->s.getCategories().stream().forEach(c -> list.add(c.getCategoriesName())));
//		return list;
//	}
	
	@Override
	public List<String> getSubBrand(String brands) {
		List<BrandsEntity> brand = brandsRepo.findBybrandsName(brands);
		List<String> list = new ArrayList<>();
		brand.stream().forEach(s ->s.getSubBrands().stream().forEach(c -> list.add(c.getSubBrandsName())));
		return list;
	}

	@Override
	public List<BrandsEntity> saveSubBrandWithBrand(List<BrandsEntity> brandEntity) {
		brandsRepo.saveAll(brandEntity);
		return brandEntity;
	}

	@Override
	public ItemsNameCodeEntity saveItems(ItemsNameCodeDto itemsDto) {
		ItemsNameCodeEntity items = new ItemsNameCodeEntity();
		BeanUtils.copyProperties(itemsDto, items);

		itemsRepo.save(items);
		log.info("Add items with this  id: " + items.getId());
		return items;
	}

	

}
