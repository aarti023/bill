package com.bill.dropdowns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dropdowns.SubBrandsEntity;

@Repository
public interface SubBrandRepo extends JpaRepository<SubBrandsEntity, Long>{

}
