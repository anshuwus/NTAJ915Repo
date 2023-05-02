package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOToMAssociationMgmtService;

@Component
public class OToMAssociationMappingRunner implements CommandLineRunner {

	@Autowired
	private IOToMAssociationMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//service.saveDataUsingParent();
		//service.saveDataUsingChild();
		//service.loadDataUsingParent();
		
		//System.out.println(service.deleteByPerson(152));
		//System.out.println(service.deleteAllPhoneNumbersOfAPerson(102));
		service.addNewChildToAParentById(102);
	}

}
