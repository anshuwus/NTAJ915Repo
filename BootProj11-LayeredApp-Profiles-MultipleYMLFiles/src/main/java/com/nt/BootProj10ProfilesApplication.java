package com.nt;

import java.beans.PropertyVetoException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
//@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj10ProfilesApplication {
	
	@Autowired
	private Environment env;
	
	/*@Bean
	public ComboPooledDataSource createC3P0DS()throws Exception {
		System.out.println("BootProj03LayeredAppRealtimeDiApplication.createC3P0DS()");
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpds.setUser("system");
		cpds.setPassword("manager");
		cpds.setInitialPoolSize(10);
		cpds.setMaxPoolSize(100);
		return cpds;
	}
	*/		
	
	@Profile("test")
	@Bean(name="c3P0Ds")
	public ComboPooledDataSource createC3P0DS() throws IllegalStateException, PropertyVetoException {
		System.out.println("BootProj04LayeredAppRealtimeDiApplication.createC3P0DS()");
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cpds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		cpds.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3P0.minSize")));
		cpds.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3P0.maxSize")));
		return cpds;
	}
	

	public static void main(String[] args) {
		// read the inputs from enduser
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Employee name::");
		String name = scn.next();
		System.out.print("Enter Employeee desg::");
		String desg = scn.next();
		System.out.print("Enter Employee basicSalary::");
		double basicSalary = scn.nextDouble();

		// create Employee class object
		Employee emp = new Employee();
		emp.setEname(name);
		emp.setDesg(desg);
		emp.setSalary(basicSalary);

		// get the IOC container

		ApplicationContext ctx = SpringApplication.run(BootProj10ProfilesApplication.class, args);
		// get Controller object
		PayrollOperationsController controller = ctx.getBean("payrollController", PayrollOperationsController.class);
		// invoke the business method
		try {
			String result = controller.processEmployee(emp);
			System.out.println(result);
		} // try
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem--Try again " + e.getMessage());
		} // catch
			// close the container
		((ConfigurableApplicationContext) ctx).close();

	}

}
