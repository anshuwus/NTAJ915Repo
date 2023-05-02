package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Doctor;

import jakarta.transaction.Transactional;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	//-----------native queries--------
	@Query(value="INSERT INTO JPA_DOCTOR_INFO VALUES(DOCID_SEQ.NEXTVAL,:name,:income,:special)",nativeQuery=true)
	@Modifying
	@Transactional
	public int registerDoctor(@Param(value = "name") String name,@Param(value="special") String special ,@Param(value="income") double income);
	//public int registerDoctor(String name,String special , double income);

	@Query(value="SELECT SYSDATE FROM DUAL",nativeQuery=true)
	public String showSystemDate();
	
	@Query(value="CREATE TABLE TEMP1(col1 number(5))",nativeQuery = true)
	public int createTempTable();
}
