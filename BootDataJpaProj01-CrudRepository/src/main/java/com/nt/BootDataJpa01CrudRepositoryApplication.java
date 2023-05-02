package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class BootDataJpa01CrudRepositoryApplication {

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootDataJpa01CrudRepositoryApplication.class, args);

		// get Service class obj
		IDoctorService service = ctx.getBean("doctorService", IDoctorService.class);

		// create Doctor class object
		Doctor doctor = new Doctor();
		Scanner scn = new Scanner(System.in);
		String docName = null;
		String spec = null;
		Double salary = null;
		try {
			
			System.out.print("Enter Doctor name:: ");
			docName=scn.next();
			System.out.print("Enter specialization:: ");
			spec=scn.next();
			System.out.print("Enter salary:: ");
			salary=scn.nextDouble();
			//set collected values to doctor object
			doctor.setDocName(docName);doctor.setSpecialization(spec);doctor.setIncome(salary);
			
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			//invoke the business method
			String resultMsg=service.registerDoctor(doctor);
			System.out.println(resultMsg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			Doctor doc1=new Doctor();
			doc1.setDocName("Rajesh2");doc1.setSpecialization("Cardio");doc1.setIncome(90000.0);
			
			Doctor doc2=new Doctor();
			doc2.setDocName("Suresh2");doc2.setSpecialization("Physician");doc2.setIncome(90000.0);
			
			Doctor doc3=new Doctor();
			doc3.setDocName("Valmiki2");doc3.setSpecialization("Ortho");doc3.setIncome(90000.0);
			
		
			//invoke the business method
			//String msg=service.registerGroupOfDoctors(List.of(doc1, doc2, doc3));
			String msg=service.registerGroupOfDoctors(Arrays.asList(doc1,doc2,doc3));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		try {
			System.out.println("count of records:: "+service.fetchDoctorsCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		/*
		try {
			System.out.println("11 Id doctor exits ?:: "+service.checkDoctorAvailbility(11));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			Iterable<Doctor> it=service.showAllDoctors();
			it.forEach(doc->{
				System.out.println(doc);
			});
			System.out.println("________________________________");
			it.forEach(System.out::println); //improved forEach(-) method of java8
			System.out.println("________________________________");
		    for(Doctor doc:it) {
		    	System.out.println(doc);//java 5 enhanced for loop
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*
		try {
			service.showAllDoctorsByIds(List.of(1, 2,3,4,5,22,33,11,44,77)).forEach(d->System.out.println(d));
			//service.showAllDoctorsByIds(List.of(1,2,3,4,55,44,33,22,11,1)).forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/

		/*
		try {
			Doctor doctor1=service.showDoctorById(110);
			System.out.println(doctor1);
			
		}                     
		catch(Exception e) {  			                   
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/

		/*try {
			System.out.println("11 doctor info:: "+service.showDoctorById(11));
			System.out.println(service.updateDoctorIncomeById(11, 20.0f));
			System.out.println("11 doctor info:: "+service.showDoctorById(11));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/

		/*try {
			Doctor doc=new Doctor();
			System.out.println("11 doctor info:: "+service.showDoctorById(11));
			doc.setDocId(11); doc.setDocName("karan"); doc.setIncome(9000.0); doc.setSpecialization("Cardio");
		    System.out.println(service.registerOrUpdateDoctor(doc));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*		
				try {
					System.out.println(service.deleteDoctorById(111));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			*/
		
		/*try {
			Doctor doc=new Doctor();
			doc.setDocId(12); doc.setDocName("Rishi");
			System.out.println(service.deleteDoctor(doc));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			System.out.println(service.removeAllDoctors());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*try {
			System.out.println(service.removeDoctorsByIds(List.of(290)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Doctor doctor1=new Doctor();
			Doctor doctor2=service.showDoctorById(2);
			System.out.println("Doctor details id 2:: "+doctor2);
			System.out.println("Doctor before deletion:: "+service.fetchDoctorsCount());
			System.out.println("Doctor is deleted: "+service.removeDoctor(List.of(doctor1,doctor2)));
			System.out.println("Doctor before deletion:: "+service.fetchDoctorsCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
				
		
		// close the container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
