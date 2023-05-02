package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;
import com.nt.service.IDoctorMgmtService;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService service;
	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("QueryMethodTestRunner.run()");
		System.out.println(service.insertDoctor("Maya", 80000.0, "Cardio"));
		System.out.println("System date time:: "+service.showSystemDate());
		//System.out.println(service.createTempDBtable());
		//doctorRepo.createTempTable();
	}

}
