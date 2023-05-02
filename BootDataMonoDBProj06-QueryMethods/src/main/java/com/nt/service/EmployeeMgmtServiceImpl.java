package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public List<Object[]> showEmpDataByAddrs(String addrs) {
		return empRepo.getEmpDataByAddrs(addrs);
	}

	@Override
	public List<Employee> showEmpAllDataByAddrs(String addrs) {
		return empRepo.getEmpAllDataByAddrs(addrs);
	}

	@Override
	public List<Employee> showEmpAllDataByAddrsAndName(String addrs, String name) {
		return empRepo.getEmpAllDataByAddrsAndName(addrs, name);
	}

	@Override
	public List<Employee> showEmpAllDataBySalaryRange(double start, double end) {
		return empRepo.getEmpAllDataBySalaryRange(start, end);
	}

	@Override
	public List<Employee> showEmpAllDataByAddresses(String addrs1, String addrs2) {
		return empRepo.getEmpAllDataAddresses(addrs1, addrs2);
	}

	@Override
	public List<Employee> showEmpAllDataByEnameInitialChars(String initialChars) {
		return empRepo.getEmpAllDataByEnameInitialChars(initialChars);
	}

}
