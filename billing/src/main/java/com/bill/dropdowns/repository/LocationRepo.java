package com.bill.dropdowns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dropdowns.LocationsEntity;

@Repository
public interface LocationRepo extends JpaRepository<LocationsEntity, Long> {

}
