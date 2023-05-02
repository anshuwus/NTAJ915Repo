package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String upsertEmployee(Employee emp,String operation) {
		if(operation.equalsIgnoreCase("add")) {
			return "Employee is saved with id value:: "+empRepo.save(emp).getEmpno();
		}
		
	    return "Employee is updated with id value:: "+empRepo.save(emp).getEmpno();
		
	}

	@Override
	public Employee editEmployee(Integer eno) {
		return empRepo.findById(eno).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
	}

	@Override
	public String deleteEmployee(Integer eno) {
		Optional<Employee> opt=empRepo.findById(eno);
		if(opt.isPresent()) {
			empRepo.deleteById(eno);
			return eno+", emp id is deleted";
		}
			
		return eno+", id not found";
	}

}
