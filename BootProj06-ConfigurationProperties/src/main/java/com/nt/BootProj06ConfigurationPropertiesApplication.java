package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx= SpringApplication.run(BootProj06ConfigurationPropertiesApplication.class, args);
	    //get Company class obj ref
		Company company=ctx.getBean("comp",Company.class);
		System.out.println(company);
		//close the conatiner
		((ConfigurableApplicationContext) ctx).close();
	}

}
