package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor; 

public interface IDoctorMgmtService {
	public List<Doctor> showDoctorsByIncomeRange(double startRange,double endRange);
    public List<Doctor> searchDoctorsBySpecialization(String sp1,String sp2);
    public List<Object[]> searchDoctorDataByIncome(double start,double end);
    public List<String> searchAllDoctorsNamesByIncomeRange(double min,double max);
    public List<String> searchDoctorNameBySpecialization(String spec);
    //@Query method for single row operations
    public Doctor searchDoctorByNameDocName(String docName);
    public Object searchDoctorDataByName(String docName);
    public String searchSpecializationByName(String docName);
    //----HQL/JPQL supports aggregate operations like count(*), max(), min(), avg()-------
    public int showDoctorNameCount();
    public Object fetchAggregateData();
    public Object fetchMaxIncome();
    //Performing non-select query operations using HQL/JPQL in @Query methods
    public int appraiseDoctorsIncomeBySpecialization(String specialization,double hikePercentage);
    public int fireDoctorsByIncomeRange(double start,double end);
    //---------native SQL Queries
   // public String insertDoctor(String name,double income,String specialization);
    //public String showSystemDate();
    public String createTempDBtable();
}
