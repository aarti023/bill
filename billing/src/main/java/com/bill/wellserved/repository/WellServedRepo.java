package com.bill.wellserved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.wellserved.model.WellServedEntity;

@Repository
public interface WellServedRepo extends JpaRepository<WellServedEntity,Long>{

}
