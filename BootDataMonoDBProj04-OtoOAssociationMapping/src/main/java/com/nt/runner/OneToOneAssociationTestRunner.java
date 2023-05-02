package com.nt.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.service.IRTOMgmtService;

@Component
public class OneToOneAssociationTestRunner implements CommandLineRunner {
	@Autowired
	private IRTOMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//parent to child
		try {
			Person per=new Person(new Random().nextInt(1000),"raja","hyd");
			DrivingLicense license=new DrivingLicense(23878923L,"2-wheeler", LocalDate.now());
			//child to parent
			per.setLicenseDetails(license); //only one side mapping is enough
			//System.out.println(service.registerPersonWithDrivingLicense(per));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		
		System.out.println("===============================");
		try {
			Person per1=new Person(new Random().nextInt(1000),"suresh","vizag");
			DrivingLicense license1=new DrivingLicense(new Random().nextLong(),"4-wheeler", LocalDate.now());
			//parent to child
			license1.setPersonDetails(per1);
			//System.out.println(service.registerLicenseWithPerson(license1));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("=============fetch all person details===============");
		service.fetchAllPersonDetails().forEach(per -> {
			System.out.println("parent:: "+per);
			DrivingLicense license=per.getLicenseDetails();
			System.out.println("child:: "+license);
		});
		System.out.println("=============fetch all license details===============");
		service.fetchAllLicenseDetails().forEach(lic -> {
			System.out.println("child:: "+lic);
			Person per=lic.getPersonDetails();
			System.out.println("Person:: "+per);
		});
	}

}
