package com.nt.runner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorMgmtService;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner{
	
	@Autowired
	private IDoctorMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("QueryMethodsTestRunner.run()");
		/*
		//		List<Doctor> row1=service.showDoctorsByIncomeRange(54000, 96000);
		//		service.showDoctorsByIncomeRange(54000, 96000).forEach(System.out::println);
		
		//		System.out.println("____________Select -- Entity Query________________");
		//		service.searchDoctorsBySpecialization("Cardio", "Ortho").forEach(System.out::println);
		System.out.println("____________Select -- Projection Query_(specific multiple col values)________");
		service.searchDoctorDataByIncome(20000.0, 100000.0).forEach(row->{ //represents Object[] in each iteration of List Collection
			for(Object obj:row) {
				System.out.print(obj+"     ");
				
			}
			System.out.println();
		});	
		
		
		System.out.println();
		service.searchDoctorDataByIncome(54000, 93500).forEach(row->{
			System.out.println(Arrays.toString(row)); //converts Object[] into String in each iteration of List collection
		});
		
		System.out.println("___________Select --Projection Query___(specific single col values__ ");
		service.searchAllDoctorsNamesByIncomeRange(90000, 97000).forEach(System.out::println);
		
		
		service.searchDoctorNameBySpecialization("Physician").forEach(System.out::println);
		System.out.println("==============================================");
		Doctor doctor=service.searchDoctorByNameDocName("raja");
		System.out.println("Doctor Info:: "+doctor);
		
		System.out.println("__________________________________");
		Object obj=service.searchDoctorDataByName("raja");
		Object data[]=(Object[])obj;
		for(Object o:data) {
			System.out.print(o+"   ");
		}
		System.out.println();
		System.out.println("Result is:: "+Arrays.toString(data));
		System.out.println("__________________________________");
		
		String result=service.searchSpecializationByName("raja");
		System.out.println("Specilization is:: "+result);
		
		System.out.println("Unique doctor names count:: "+service.showDoctorNameCount());
		System.out.println("______________________________________");
		Object[] results=(Object[])service.fetchAggregateData();
		System.out.println("Records count:: "+results[0]);
		System.out.println("Max income count:: "+results[1]);
		System.out.println("Min income count:: "+results[2]);
		System.out.println("Avg income count:: "+results[3]);
		System.out.println("Sum income count:: "+results[4]);
		System.out.println("===========================================");
		Object[] object=(Object[])service.fetchMaxIncome();
		for(Object o:object) {
			System.out.println(o+"  ");
		}
		System.out.println();
		*/
        
        System.out.println("__________Non-select operations____________");
        int count=service.appraiseDoctorsIncomeBySpecialization("Cardio",10.0);
        System.out.println("No. of records that are effected:: "+count);
        
//        System.out.println("Deleted doctors count:: "+service.fireDoctorsByIncomeRange(20000, 24000));
	
        System.out.println("__________native SQL Queries________________");
		/*
		System.out.println();
		System.out.println(service.insertDoctor("Suresh",80000.0, "Cardio"));
		*/
        
       // System.out.println("System date time:: "+service.showSystemDate());
	
        System.out.println(service.createTempDBtable());
	}
	
}
