package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtServcice;

@Controller("payrollController")
public class PayrollOperationsController {

	@Autowired
	private IEmployeeMgmtServcice service;
	
	public String processEmployee(Employee emp)throws Exception{
		//delegate the request to Service class
		String result=service.registerEmployee(emp);
		return result;
	}
}
