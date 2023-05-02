package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("OToMService")
public class OToMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {
	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	
	@Override
	public List<Object[]> fetchDataUsingJoins() {
		return personRepo.getDataUsingJoins();
	}

}//class close
