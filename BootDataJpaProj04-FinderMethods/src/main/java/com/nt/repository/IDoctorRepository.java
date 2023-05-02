package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	//select docId,docName,specialization,income from doctor where docName=?
	public List<Doctor> findByDocNameEquals(String name);
	
	//select docId,docName,specialization,income from doctor where docName=?
	public List<Doctor> findByDocNameIs(String name);
		
	//select docId,docName,specialization,income from doctor where docName=?
	public List<Doctor> findByDocName(String name);
	
	//select docId,docName,specialization,income from doctor where docName like 'r%'
	public Iterable<Doctor> findByDocNameStartingWith(String initChars);
	//select docId,docName,specialization,income from doctor where docName like '%n'
	public Iterable<Doctor> findByDocNameEndingWith(String lastChars);
	//select docId,docName,specialization,income from doctor where docName like '%im%'
	public Iterable<Doctor> findByDocNameContaining(String chars);
	//select docId,docName,specialization,income from doctor where docName like '%IM%'
	public Iterable<Doctor> findByDocNameEqualsIgnoreCase(String chars);
	public Iterable<Doctor> findByDocNameLike(String chars);
	
	//And or Or clause
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange,double endRange);
	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials,double start,double end);


}
