package com.nt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PatientController;
import com.nt.model.Patient;

@SpringBootApplication
public class LayeredAppDiCovidApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx=SpringApplication.run(LayeredAppDiCovidApplication.class, args);
	    //get controller class object
		PatientController controller=ctx.getBean("patientController",PatientController.class);
		
		//read inputs from enduser
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Patient name::");
		String pname=scn.next();
		System.out.print("Enter Patient address::");
		String paddr=scn.next();
		System.out.print("Enter Patient gender::");
		String pgen=scn.next();
		System.out.print("Enter Patient age::");
		byte page=scn.nextByte();
	
		//create Patient obj
		Patient pnt=new Patient();
		pnt.setPname(pname);
		pnt.setPaddrs(paddr);
		pnt.setSex(pgen);
		pnt.setAge(page);
		
		try {
			//ivoke the business method
			String result=controller.processPatient(pnt);
			System.out.println(result);
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem-- Try again");
		}//catch
		
		//close the container
		((ConfigurableApplicationContext)ctx).close();
	}//method

}//class
