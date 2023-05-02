package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Override
	public String insertDoctor(String name, double income, String specialization) {
		int count=doctorRepo.registerDoctor(name, specialization, income);
		return count==0?" Doctor not registered ":" Doctor is registerd";
	}

	@Override
	public String showSystemDate() {
		return doctorRepo.showSystemDate();
	}

	@Override
	public String createTempDBtable() {
		int count=doctorRepo.createTempTable();
		return count==0?" DB table is created ": " DB table is not created";
	}

}
