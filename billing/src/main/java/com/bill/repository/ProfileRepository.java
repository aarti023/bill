package com.bill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.model.ProfileEntity;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>{

	Optional<ProfileEntity> getProfileByEmployeeCode(String employeeCode);

}
