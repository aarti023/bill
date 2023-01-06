package com.bill.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dto.RelationDto;
import com.bill.model.RelationsEntity;
import com.bill.repository.RelationsRepo;
import com.bill.service.RelationService;

@Service
public class RelationServiceImpl implements RelationService{
	
	@Autowired
	private RelationsRepo relationsRepo;

	@Override
	public RelationsEntity saveRelations(RelationDto relationDto) {
		RelationsEntity relation = new RelationsEntity();
		BeanUtils.copyProperties(relationDto, relation);
		relationsRepo.save(relation);
		return relation;
	}

}
