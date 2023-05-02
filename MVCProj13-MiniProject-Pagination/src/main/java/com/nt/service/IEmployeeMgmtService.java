package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	
	public Iterable<Employee> getAllEmployees();
	public String upsertEmployee(Employee emp,String operation);
	public Employee editEmployee(Integer eno);
	public String deleteEmployee(Integer eno);
	
	public List<Integer> fetchAllDeptno();
	public boolean IsDesgInRejectedList(String desg);
	
	public Page<Employee> getEmployeeReportDataByPage(Pageable pageable);
}
