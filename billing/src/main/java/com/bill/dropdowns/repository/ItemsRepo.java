package com.bill.dropdowns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dropdowns.ItemsNameCodeEntity;

@Repository
public interface ItemsRepo extends JpaRepository<ItemsNameCodeEntity, Long>{

}
