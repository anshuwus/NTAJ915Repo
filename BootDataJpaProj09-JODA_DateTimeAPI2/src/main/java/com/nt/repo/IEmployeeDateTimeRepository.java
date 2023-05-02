package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee_Date_Time;

public interface IEmployeeDateTimeRepository extends JpaRepository<Employee_Date_Time, Integer>{
	@Query(nativeQuery=true, value="SELECT ename,YEAR(CURRENT_TIMESTAMP)-YEAR(DOB) FROM Employee_Date_Time WHERE DESG=:job")
	public List<Object[]> getEmployeeAgesByDesg(String job);
}
