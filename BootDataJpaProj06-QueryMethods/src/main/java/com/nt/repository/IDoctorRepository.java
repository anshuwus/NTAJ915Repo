package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Doctor;

import jakarta.transaction.Transactional;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	// @Query("FROM Doctor WHERE income>=?1 AND income<=?2")
	// @Query("FROM com.nt.entity.Doctor WHERE income>=?1 AND income<=?2")
	// @Query("FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
	// @Query("FROM com.nt.entity.Doctor doc WHERE doc.income>=?1 AND
	// doc.income<=?2")
	// @Query("SELECT doc FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
	// public List<Doctor> searchDoctorByIncomeRange(double startRange,double
	// endRange);

	@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor> searchDoctorByIncomeRange(@Param("start") double startRange, @Param("end") double endRange);

	// --------Select- Entity Query-------
	@Query("FROM Doctor WHERE specialization IN(:sp1,:sp2) ORDER BY specialization")
	public List<Doctor> searchDoctorsBySpecialization(String sp1, String sp2);

	// --------Select- Projection Query with specific multiple col values
	@Query("SELECT docId,docName,income FROM Doctor WHERE income between :start and :end")
	public List<Object[]> searchDoctorDataByIncome(double start, double end);

	// --------Select- Projection Query with specific single col values
	@Query("SELECT docName FROM Doctor WHERE income between :min and :max")
	public List<String> searchAllDoctorsNamesByIncomeRange(double min, double max);

	@Query("SELECT docName From Doctor WHERE specialization=:spec")
	public List<String> searchDoctorNameBySpecialization(String spec);

	// @Query method for single row operations
	// -------------Entity Query giving single records---------------
	@Query("FROM Doctor where docName=:name") // assume that doctor
	public Optional<Doctor> showDoctorInfoByName(String name);

	// -------------Scalar/Projection Query giving single record multiple col
	// values---------
	@Query("SELECT docId,docName FROM Doctor where docName=:name")
	public Object showDoctorDataByName(String name);

	// -------------Scalar/Projection Query giving single record single col
	// values-----------
	@Query("SELECT specialization FROM Doctor where docName=:name")
	public String showSpecializationByName(String name);

	// ----HQL/JPQL supports aggregate operations like count(*), max(), min(),
	// avg()-------
	@Query("SELECT count(distinct docName) FROM Doctor")
	public int fetchDoctorsNameCount();

	@Query("SELECT count(*),max(income),min(income),avg(income),sum(income) from Doctor")
	public Object fetchAggregateData();

	// Max income with name
	@Query("SELECT docName,income FROM Doctor order by income desc limit 1")
	public Object fetchMaxIncome();

	// Performing non-select query operations using HQL/JPQL in @Query methods
	@Query("update Doctor SET income=income+(income * :percentage/100.0) WHERE specialization=:sp")
	@Modifying
	@Transactional
	public int hikeDoctorsIncomeBySpeciliazation(String sp, double percentage);

	@Query("DELETE FROM Doctor WHERE income>=:start AND income<=:end")
	@Modifying
	@Transactional
	public int removeDoctorsByIncomeRange(double start, double end);

	/* 
		//-----------------native SQL Queries---------------
			@Query(value="INSERT INTO JPA_DOCTOR_INFO VALUES(:name,:income,:special)",nativeQuery=true)
			@Modifying
			@Transactional
		public int registerDoctor(String name,String special,double income);
			
		
		@Modifying
			@Transactional
		//@Query(value="SELECT NOW() FROM DUAL", nativeQuery=true)
		@Query(value="SELECT SYSDATE FROM DUAL", nativeQuery=true)
			public String showSystemDate();
		*/
	
	
	
	@Query(value = "CREATE TABLE TEMP(NAME VARCHAR2(10))", nativeQuery = true)
	@Modifying
	@Transactional
	public int createTempTable();

}
