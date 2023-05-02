package com.nt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03LayeredAppRealtimeDiApplication {

	public static void main(String[] args) {
		//read the inputs from enduser
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter Employee name::");
		String name=scn.next();
		System.out.print("Enter Employeee desg::");
		String desg=scn.next();
		System.out.print("Enter Employee basicSalary::");
		double basicSalary=scn.nextDouble();
		
		//create Employee class object
		Employee emp=new Employee();
		emp.setEname(name);
		emp.setDesg(desg);
		emp.setSalary(basicSalary);
		
		//get the IOC container
		
		ApplicationContext ctx=SpringApplication.run(BootProj03LayeredAppRealtimeDiApplication.class, args);
		//get Controller object
		PayrollOperationsController controller=ctx.getBean("payrollController",PayrollOperationsController.class);
		//invoke the business method
		try {
			String result=controller.processEmployee(emp);
			System.out.println(result);
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem--Try again "+e.getMessage());
		}//catch
		//close the container
		((ConfigurableApplicationContext)ctx).close();
	}

}
