package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner{
	
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public void run(String... args) throws Exception {
		//----finder methods----
		doctorRepo.findByDocNameEquals("raja").forEach(System.out::println);;
		System.out.println("---------------------------");
		doctorRepo.findByDocNameIs("Riya").forEach(System.out::println);
		System.out.println("---------------------------");
        doctorRepo.findByDocName("Raghav").forEach(System.out::println);
		System.out.println("---------------------------");

		doctorRepo.findByDocNameStartingWith("r").forEach(System.out::println);
		System.out.println("---------------------------");
		doctorRepo.findByDocNameEndingWith("a").forEach(System.out::println);
		System.out.println("---------------------------");
        doctorRepo.findByDocNameContaining("iM").forEach(System.out::println);
		System.out.println("---------------------------");
        doctorRepo.findByDocNameEqualsIgnoreCase("rAJa").forEach(System.out::println);
		System.out.println("---------------------------");
		doctorRepo.findByDocNameLike("%a").forEach(System.out::println);
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		Iterable<Doctor> it=doctorRepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(60000, 200000);
		it.forEach(System.out::println);
		System.out.println("---------------------------");
		
		doctorRepo.findBySpecializationInOrIncomeBetween(List.of("Ortho", "cardio"), 3000, 7000).forEach(System.out::println);
	}
	
	
}
