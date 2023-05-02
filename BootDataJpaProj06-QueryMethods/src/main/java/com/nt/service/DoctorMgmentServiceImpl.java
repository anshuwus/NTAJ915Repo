package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmentServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public List<Doctor> showDoctorsByIncomeRange(double startRange, double endRange) {
		return doctorRepo.searchDoctorByIncomeRange(startRange, endRange);
	}

	@Override
	public List<Doctor> searchDoctorsBySpecialization(String sp1, String sp2) {
		return doctorRepo.searchDoctorsBySpecialization(sp1, sp2);
	}

	@Override
	public List<Object[]> searchDoctorDataByIncome(double start, double end) {
		return doctorRepo.searchDoctorDataByIncome(start, end);
	}

	@Override
	public List<String> searchAllDoctorsNamesByIncomeRange(double min, double max) {
		return doctorRepo.searchAllDoctorsNamesByIncomeRange(min, max);
	}

	@Override
	public List<String> searchDoctorNameBySpecialization(String spec) {
		return doctorRepo.searchDoctorNameBySpecialization(spec);
	}

	@Override
	public Doctor searchDoctorByNameDocName(String docName) {
		return doctorRepo.showDoctorInfoByName(docName)
				.orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
	}

	@Override
	public Object searchDoctorDataByName(String docName) {
		return doctorRepo.showDoctorDataByName(docName);
	}

	@Override
	public String searchSpecializationByName(String docName) {
		return doctorRepo.showSpecializationByName(docName);
	}

	@Override
	public int showDoctorNameCount() {
		return doctorRepo.fetchDoctorsNameCount();
	}

	@Override
	public Object fetchAggregateData() {
		return doctorRepo.fetchAggregateData();
	}

	@Override
	public Object fetchMaxIncome() {
		return doctorRepo.fetchMaxIncome();
	}

	@Override
	public int appraiseDoctorsIncomeBySpecialization(String specialization, double hikePercentage) {
		return doctorRepo.hikeDoctorsIncomeBySpeciliazation(specialization, hikePercentage);
	}

	@Override
	public int fireDoctorsByIncomeRange(double start, double end) {
		return doctorRepo.removeDoctorsByIncomeRange(start, end);
	}

			
		
		/*		public String insertDoctor(String name, double income, String specialization) {
					return doctorRepo.registerDoctor(name, specialization, income)==0?" Doctor not registered":" Doctor is registered";
				}
				
				@Override
				public String showSystemDate() {
					return doctorRepo.showSystemDate();
				}
		*/

	@Override
	public String createTempDBtable() {
		int count = doctorRepo.createTempTable();
		return count == 0 ? " DB table is created " : " DB table is not created";
	}
}
