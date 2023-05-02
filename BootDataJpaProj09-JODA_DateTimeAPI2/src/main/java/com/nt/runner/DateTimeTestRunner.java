package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee_Date_Time;
import com.nt.service.IEmployeeMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner{

	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*try {
			//save the object
			Employee_Date_Time emp=new Employee_Date_Time("rahul","CA",
					                                             LocalDateTime.of(1994, 1,22,10,12),
					                                             LocalTime.of(12, 00),
					                                             LocalDate.of(2022, 12, 12));
		    String result=service.saveEmployee(emp);
		    System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		try {
			service.getAllEmployees().forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		try {
			service.showEmployeeAgesByDesg("clerk").forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"   ");
				}
				System.out.println();
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
