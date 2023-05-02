package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, Integer> {
	
	//============Projection Query==========
	//@Query(fields="{eno:0,eadd:1,salary:1}", value="{eadd:?0}")  //where eadd=?
	@Query(fields="{ename:1,eadd:1,salary:1}", value="{eadd:?0}")
	public List<Object[]> getEmpDataByAddrs(String addrs);
	
	//============Entity Queries============
	//@Query(fields="{}", value="{eadd:?0}")
	@Query(value="{eadd:?0}")
	public List<Employee> getEmpAllDataByAddrs(String addrs);
	
	@Query(value="{eadd:?0,ename:?1}") //where eadd=? and ename=?
	public List<Employee> getEmpAllDataByAddrsAndName(String addrs,String name);
	
	@Query(value="{salary:{$gte:?0,$lte:?1}}") //where salary>=? and salary<=?
	public List<Employee> getEmpAllDataBySalaryRange(double startSalary,double endSalary);
	
	@Query(value="{$or:[{eadd:?0},{eadd:?1}]}")
	public List<Employee> getEmpAllDataAddresses(String addrs1,String addrs2);
	
	//@Query(value="{ename:{'$regex':?0}}") //where ename like
	@Query(value="{ename:{'$regex}':?0,'$options':'i'}}")  //'i' for case insensitvity is applied
	public List<Employee> getEmpAllDataByEnameInitialChars(String initialChars);
}
