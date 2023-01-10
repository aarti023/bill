package com.bill.service.impl;

import java.security.SecureRandom;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dto.LoginDto;
import com.bill.dto.RelationDto;
import com.bill.exception.LoginResponseException;
import com.bill.model.RelationsEntity;
import com.bill.repository.RelationsRepo;
import com.bill.service.RelationService;

@Service
public class RelationServiceImpl implements RelationService {

	@Autowired
	private RelationsRepo relationsRepo;

	@Override
	public RelationsEntity saveRelations(RelationDto relationDto) {
		RelationsEntity relation = new RelationsEntity();
		BeanUtils.copyProperties(relationDto, relation);
		relation.setPassword(generatePassword(relationDto.getEmployeeCode()));
		relationsRepo.save(relation);
		return relation;
	}
	
	public static String generatePassword(String paswd) {
	    String characters = "abcdefghijklmnopqrstuvwxyz0123456789@";
	    SecureRandom rnd = new SecureRandom();
	    char[] password = new char[8];
	    for (int i = 0; i < 8; i++) {
	      password[i] = characters.charAt(rnd.nextInt(characters.length()));
	    }
	    return new String(password);
	  }

	@Override
	public LoginDto forgetPassword(String email,String employeeCode) {
		Optional<RelationsEntity> relationsEntity = relationsRepo.findOneByEmployeeCodeAndEmail(employeeCode,email);
		
		if (relationsEntity.isPresent()) {
			LoginDto login = new LoginDto();
			String pass = generatePassword(relationsEntity.get().getEmployeeCode());
			login.setEmployeeCode(relationsEntity.get().getEmployeeCode());
			login.setPassword(pass);
			relationsEntity.get().setPassword(pass);
			relationsRepo.save(relationsEntity.get());
			return login;
		}
	    throw new LoginResponseException("not valid");
	}

}
