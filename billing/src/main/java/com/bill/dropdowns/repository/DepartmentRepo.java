package com.bill.dropdowns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dropdowns.Departments;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments, Long> {

	List<Departments> findByDepartmentName(String department);

}
