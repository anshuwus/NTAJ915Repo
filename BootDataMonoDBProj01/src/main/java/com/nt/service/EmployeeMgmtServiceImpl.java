package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public String saveEmployee(Employee e) {
		return "MongoDB is saved with id value:: "+empRepo.insert(e).getId();
	}

	@Override
	public List<Employee> showAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String saveMoreEmployee(List<Employee> e) {
		if(e!=null) {
			List<Employee> savedEmp=empRepo.saveAll(e);
			int size=savedEmp.size();
			List<String> ids=new ArrayList<String>();
			savedEmp.forEach(d -> {
				ids.add(d.getId());
			});
			return size+" no. of Employee are saved with id values:: "+ids.toString();
		}
		else {
			throw new IllegalArgumentException("Emp not saved");
		}
	}

	@Override
	public String searchEmployeeById(String idVal) {
		Optional<Employee> opt=empRepo.findById(idVal);
		if(opt.isPresent()) {
			return opt.get().toString();
		}
		return "Document not found";
	}

	@Override
	public String modifyEmployeeById(String idVal, Double percentage) {
		Optional<Employee> opt=empRepo.findById(idVal);
		if(opt.isPresent()) {
			Employee emp=opt.get();
			emp.setSalary(emp.getSalary()+(emp.getSalary()*percentage/100.0));
			empRepo.save(emp);
			return "Document found and updated";
		}
		return "Document is not found";
	}

	@Override
	public String removeEmployeeById(String idVal) {
		Optional<Employee> opt=empRepo.findById(idVal);
		if(opt.isPresent()) {
			empRepo.deleteById(idVal);
			return "Document found and deleted";
		}else {
			return "Document not found";
		}
	}

	@Override
	public List<Employee> showAllEmployees(boolean asc, String... properties) {
		//create the Sort object
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,properties);
		//get the docs by sorting
		List<Employee> list=empRepo.findAll(sort);
		return list;
	}

	@Override
	public List<Employee> searchEmployeeData(Employee emp, boolean asc, String... props) {
		Example<Employee> example=Example.of(emp);
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		List<Employee> list=empRepo.findAll(example,sort);
		return list;	
	}

	@Override
	public String saveEmployeeUUID(Employee e) {
		return "MongoDB Document is saved with id value:: "+empRepo.insert(e).getId();
	}

	
	

}
