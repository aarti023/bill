package com.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bill.model.ItemsEntity;

public interface ItemRepo extends JpaRepository<ItemsEntity,Long>{

}
