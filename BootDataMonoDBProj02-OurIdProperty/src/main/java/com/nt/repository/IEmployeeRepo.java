package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.entity.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, Integer> {
	public List<Employee> findBySalaryBetween(double start,double end);
	
}
