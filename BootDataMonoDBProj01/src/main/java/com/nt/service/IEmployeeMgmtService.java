package com.nt.service;

import java.util.List;

import com.nt.document.Employee;


public interface IEmployeeMgmtService {
	public String saveEmployee(Employee e);
	public List<Employee> showAllEmployees();
	public String saveMoreEmployee(List<Employee> e);
	public String searchEmployeeById(String idVal);
	public String modifyEmployeeById(String idVal,Double newSal);
	public String removeEmployeeById(String idVal);
	//getting documents by applying sorting
	public List<Employee> showAllEmployees(boolean asc,String... properties);
	public List<Employee> searchEmployeeData(Employee emp,boolean asc,String... props);
	//Generating id value using UUID generators
	public String saveEmployeeUUID(Employee e);
}
