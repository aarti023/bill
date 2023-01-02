package com.bill.dropdowns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dropdowns.ExpensesTypeEntity;

@Repository
public interface ExpensesRepo extends JpaRepository<ExpensesTypeEntity, Long> {

}
