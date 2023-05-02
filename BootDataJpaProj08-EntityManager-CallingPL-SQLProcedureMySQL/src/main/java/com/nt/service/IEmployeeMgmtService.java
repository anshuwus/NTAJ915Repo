package com.nt.service;

import java.util.List;

import com.nt.entity.Employee_Info;

public interface IEmployeeMgmtService {
	public List<Employee_Info> showEmployeeBySalaryRange(double start,double end);
}
