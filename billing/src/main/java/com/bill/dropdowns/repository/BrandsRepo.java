package com.bill.dropdowns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dropdowns.BrandsEntity;

@Repository
public interface BrandsRepo extends JpaRepository<BrandsEntity, Long>{

	List<BrandsEntity> findBybrandsName(String brand);

}
