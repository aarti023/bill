package com.bill.dropdowns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dropdowns.ItemsEntity;

@Repository
public interface ItemsRepo extends JpaRepository<ItemsEntity, Long>{

}
