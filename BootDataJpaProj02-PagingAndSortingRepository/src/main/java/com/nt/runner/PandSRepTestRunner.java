package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class PandSRepTestRunner implements CommandLineRunner{
	
	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
		System.out.println("______________________________");
		service.showDoctorsBySorting(false, "income","docName").forEach(System.out::println);;
		
		
		/*try {
			//service.showDoctorsInfoByPageNo(1, 3, false, "docName").forEach(System.out::println);;
			Page<Doctor> page=service.showDoctorsInfoByPageNo(0, 3, false, "docName");
		    System.out.println("Page Elements count:: "+page.getContent());
			System.out.println("Page Number:: "+page.getNumber());
		    System.out.println("Pages Count:: "+page.getTotalPages());
		    System.out.println("Is it first page:: "+page.isFirst());
		    System.out.println("Is it last page:: "+page.isLast());
		    System.out.println("Page size:: "+page.getSize());
		    System.out.println("Page Elements count:: "+page.getNumberOfElements());
		    
		    if(!page.isEmpty()) {
		    	List<Doctor> list=page.getContent();
		    	list.forEach(System.out::println);
		    }
		    else {
		    	System.out.println("No page found");
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		service.showDataThroughPagination(3);
		
	}
	
	
}
