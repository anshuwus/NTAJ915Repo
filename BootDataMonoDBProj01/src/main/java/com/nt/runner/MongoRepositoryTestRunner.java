package com.nt.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		Employee e=new Employee();
		e.setEno(101); e.setEname("rajesh"); e.setEadd("hyd"); e.setSalary(97000.0); e.setIsVaccinated(null);
		//System.out.println(service.saveEmployee(e));
		
		//-----------findAll Documents methods----------
		//service.showAllEmployees().forEach(System.out::println);
		
		//----------batch insertion-------
		Employee e1=new Employee(null,107, "deep", "mp", 70000.0, true);
		Employee e2=new Employee(null,108, "anshi", "haryana", null, false);
		Employee e3=new Employee("hiuhgjh",108, "varsha", "merut", 57000.0, true);
		//String msg=service.saveMoreEmployee(Arrays.asList(e1,e2,e3));
		//System.out.println("-->"+msg);
		
		System.out.println("Document info:: "+service.searchEmployeeById("hiuhgjh"));
		//-----------updating the document----------
		//System.out.println(service.modifyEmployeeById("hiuhgjh", 10.0));
		System.out.println("Document info:: "+service.searchEmployeeById("hiuhgjh"));
		
		//-----------Deleting the document----------
		System.out.println(service.removeEmployeeById("640cc732299a093a8f2d375f"));
		//find all the docs after applying sorting
		//service.showAllEmployees(true,"ename").forEach(System.out::println);;
		Employee emp=new Employee();
		emp.setSalary(90000.0); emp.setEadd("delhi");
		try {
			//service.searchEmployeeData(emp, false, "ename").forEach(System.out::println);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		Employee emp1=new Employee();
		emp1.setId(UUID.randomUUID().toString());
		emp1.setEno(156); emp1.setEname("mahesh"); emp1.setEadd("mumbai"); emp1.setSalary(94500.0); emp1.setIsVaccinated(true);
		//System.out.println(service.saveEmployeeUUID(emp1));
		//service.showAllEmployees().forEach(System.out::println);

	}

}
