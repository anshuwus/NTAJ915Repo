package com.nt.runner;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;


@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//create Document object
		Employee e=new Employee();
		e.setEno(new Random().nextInt(10000));
		e.setEname("lokesh"); e.setEadd("delhi"); e.setIsVaccinated(true); e.setSalary(45600.0);
		//System.out.println(service.registerEmployee(e));
		
		Optional<Employee> opt=service.showEmployeeById(6181);
		if(opt.isPresent()) {
			System.out.println("Employee details:: "+opt.get());
		}
		else
			System.out.println("Employee not found");
		
		service.searchEmployeeBySalaryRange(40000.0, 50000.0).forEach(System.out::println);;
	
	}

}


