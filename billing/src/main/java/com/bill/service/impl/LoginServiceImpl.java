package com.bill.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dto.LoginDto;
import com.bill.dto.LoginResponseDto;
import com.bill.exception.LoginResponseException;
import com.bill.model.LoginEntity;
import com.bill.model.RelationsEntity;
import com.bill.repository.LoginRepo;
import com.bill.repository.RelationsRepo;
import com.bill.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepo loginRepo;

	@Autowired
	private RelationsRepo relationRepo;

	@Override
	public LoginResponseDto saveLogin(LoginDto loginDto) {
		Optional<RelationsEntity> relation = relationRepo.findOneByEmployeeCodeAndPassword(loginDto.getEmployeeCode(),
				loginDto.getPassword());

		if (relation.isPresent()) {

			Optional<LoginEntity> logins = loginRepo.findByEmail(relation.get().getEmail());
			if (logins.isPresent()) {
				throw new LoginResponseException("This user already logged in");
			} else {
				RelationsEntity relationEntity = relation.get();
				LoginEntity login = new LoginEntity();
				login.setEmail(relationEntity.getEmail());
				login.setEmployeeCode(relationEntity.getEmployeeCode());
				login.setEmployeeName(relationEntity.getEmployeeName());
				login.setStatus(true);
				login.setPassword(relationEntity.getPassword());
				login.setUserType(relationEntity.getUserType());
				login.setReportingManager(relationEntity.getReportingManager());
	
				LoginEntity loginEntity = loginRepo.save(login);
				LoginResponseDto loginResponseDto = new LoginResponseDto();
				loginResponseDto.setEmail(relationEntity.getEmail());
				loginResponseDto.setStatus(true);
				loginResponseDto.setEmployeeName(relationEntity.getEmployeeName());
				loginResponseDto.setUserType(relationEntity.getUserType());
				loginResponseDto.setEmployeeCode(relationEntity.getEmployeeCode());
				loginResponseDto.setReportingManager(relationEntity.getReportingManager());
				return loginResponseDto;

			}
		}
		throw new LoginResponseException("This is not vaild");
	}

	@Override
	public String logOut(String email, String employeeCode) {
		Optional<RelationsEntity> relationsEntity = relationRepo.findOneByEmployeeCodeAndEmail(employeeCode, email);

		if (relationsEntity.isPresent()) {
			Optional<LoginEntity> loginEntitiy = loginRepo.findOneByEmployeeCodeAndEmail(employeeCode, email);
			if (loginEntitiy.isPresent()) {
				loginRepo.delete(loginEntitiy.get());
				return "loged out";
			}
			throw new LoginResponseException("Login first");
		}
		throw new LoginResponseException("not valid");
	}

}
