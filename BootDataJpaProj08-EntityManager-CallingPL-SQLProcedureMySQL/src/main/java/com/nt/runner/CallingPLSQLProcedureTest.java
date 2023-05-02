
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeMgmtService;

@Component
public class CallingPLSQLProcedureTest implements CommandLineRunner {
	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//invoke the b.method of service
		service.showEmployeeBySalaryRange(50000.0, 100000.0).forEach(System.out::println);;
	}
}
