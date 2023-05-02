package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorService {
	public String registerDoctor(Doctor doctor);
	public String registerGroupOfDoctors(Iterable<Doctor> doctors);
	public long fetchDoctorsCount();
	public boolean checkDoctorAvailbility(Integer id);
	public Iterable<Doctor> showAllDoctors();
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids);
	public Doctor showDoctorById(Integer id);
	public String updateDoctorIncomeById(Integer id,float hikePercentage);
	public String registerOrUpdateDoctor(Doctor doctor);
	public String deleteDoctorById(Integer id);
	public String deleteDoctor(Doctor doctor);
	public String removeAllDoctors();
	public String removeDoctorsByIds(List<Integer> ids);
	public String removeDoctor(List<Doctor> doctor);
}
