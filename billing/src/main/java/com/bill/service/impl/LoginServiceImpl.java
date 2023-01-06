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
	public LoginResponseDto  saveLogin(LoginDto loginDto) {

//		RelationsEntity relation = relationRepo.findByEmployeeCode();
		Optional<RelationsEntity> userentity = relationRepo.findOneByEmployeeCodeAndPassword(loginDto.getEmployeeCode(),
				loginDto.getPassword());
		

		if (userentity.isPresent()) {
			
			Optional<LoginEntity> loginti= loginRepo.findByEmail(userentity.get().getEmail());
			if(loginti.isPresent()) {
				 throw new LoginResponseException("This user already logged in");
			}
			else {
				RelationsEntity us=userentity.get();
				LoginEntity loginobj=new LoginEntity();
				loginobj.setEmail(us.getEmail());
				loginobj.setEmployeeCode(us.getEmployeeCode());
				loginobj.setEmployeeName(us.getEmployeeName());
				loginobj.setStatus(true);
				loginobj.setUserType(us.getUserType());
				LoginEntity le= loginRepo.save(loginobj);
				LoginResponseDto loginResponseDto=new LoginResponseDto();
				loginResponseDto.setEmail(us.getEmail());
				loginResponseDto.setStatus(true);
				return loginResponseDto;
				
			}
		}
		throw new LoginResponseException("This is not vaild");
	}


}
