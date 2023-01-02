package com.bill.dropdowns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dropdowns.CategoriesEntity;

@Repository
public interface CategoriesRepo extends JpaRepository<CategoriesEntity, Long>{

}
