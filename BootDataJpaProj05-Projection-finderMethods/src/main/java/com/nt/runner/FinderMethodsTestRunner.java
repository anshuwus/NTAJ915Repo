package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;
import com.nt.view.IResultView1;
import com.nt.view.IResultView2;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner{
	
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public void run(String... args) throws Exception {
		Iterable<IResultView1> it=doctorRepo.findBySpecializationIn(List.of("cardio","Ortho"));
		
		it.forEach(doc->{
			//head "doc" represents the InMemory Proxy class implementing IResultView(I)
			System.out.println(doc.getDocName()+"......"+doc.getIncome());
		});
		
		System.out.println("-------------------------------------");
		Iterable<IResultView1> it1=doctorRepo.findByIncomeBetween(53000.0, 200000, IResultView1.class);
		it1.forEach(data->{
			System.out.println(data.getDocName()+"..."+data.getIncome());
		});
		System.out.println("______________________________________");
		Iterable<IResultView2> it2=doctorRepo.findByIncomeBetween(60000, 200000, IResultView2.class);
		it2.forEach(data->{
			System.out.println(data.getDocName()+"..."+data.getSpecialization()+"..."+data.getIncome());
		});
	}
}
