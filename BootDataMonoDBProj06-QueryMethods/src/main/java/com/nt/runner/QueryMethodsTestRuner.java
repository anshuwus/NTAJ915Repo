package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeMgmtService;

@Component
public class QueryMethodsTestRuner implements CommandLineRunner{
	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*service.showEmpDataByAddrs("hyd").forEach(row ->{
			for(Object val:row) {
				System.out.print(val+"   ");
			}
			System.out.println();
		});*/
		
		//service.showEmpAllDataByAddrs("hyd").forEach(System.out::println);
		System.out.println("=============================");
		//service.showEmpAllDataByAddrsAndName("hyd", "rajesh").forEach(System.out::println);
		System.out.println("=============================");
		//service.showEmpAllDataBySalaryRange(45000.0, 50000.0).forEach(System.out::println);
		System.out.println("=============================");
		//service.showEmpAllDataByAddresses("delhi", "hyd").forEach(System.out::println);
		System.out.println("=============================");
		service.showEmpAllDataByEnameInitialChars("r").forEach(System.out::println);
	}

}
