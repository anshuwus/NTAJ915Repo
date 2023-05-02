package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj09ComplexYmlApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj09ComplexYmlApplication.class, args);
		//get Employee obj ref
		Employee emp=ctx.getBean("emp",Employee.class);
	    //print object data
		 System.out.println(emp);
		//close the container
		 ((ConfigurableApplicationContext) ctx).close();
	}

}
