package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public String registerEmployee(Employee e) {
		return "MongoDB Doc is saved with id value:: "+empRepo.insert(e).getEno();
	}

	@Override
	public Optional<Employee> showEmployeeById(int id) {
		return empRepo.findById(id);
	}

	@Override
	public List<Employee> searchEmployeeBySalaryRange(double start, double end) {
		List<Employee> list=empRepo.findBySalaryBetween(start, end);
		return list;
	}

}
