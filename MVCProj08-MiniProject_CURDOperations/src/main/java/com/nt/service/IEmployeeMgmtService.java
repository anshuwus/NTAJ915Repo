package com.nt.service;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	
	public Iterable<Employee> getAllEmployees();
	public String upsertEmployee(Employee emp,String operation);
	public Employee editEmployee(Integer eno);
	public String deleteEmployee(Integer eno);
}
