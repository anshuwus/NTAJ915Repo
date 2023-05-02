package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_Date_Time;
import com.nt.repo.IEmployeeDateTimeRepository;

@Service("empService")
public class EmployeeDateTimeRepository implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDateTimeRepository empRepo;
	
	@Override
	public String saveEmployee(Employee_Date_Time dateTime) {
		int idVal=empRepo.save(dateTime).getEno();
		return "Employee Object is saved with the id value:: "+idVal;
	}

	@Override
	public List<Employee_Date_Time> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public List<Object[]> showEmployeeAgesByDesg(String desg) {
		return empRepo.getEmployeeAgesByDesg(desg);
	}

}
