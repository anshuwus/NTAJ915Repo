package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService empService;
	
	//to show the home page
	@GetMapping("/")
	public String showHome() {
		System.out.println("EmployeeOperationsController.showHome()");
		return "home";
	}
	
	
	
	@GetMapping("/add")
	public String showFormForSaveEmployee(@ModelAttribute("emp")Employee emp) {
		//return LVN
		return "register_employee";
	}
	
	/*@PostMapping("/add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,Map<String,Object> map) {
		//use service
		String msg=empService.registerEmployee(emp);
		Iterable<Employee> itEmps=empService.getAllEmployees();
		//keep the result in ModelAttribute
		map.put("resultMsg", msg);
		map.put("empsList", itEmps);
		return "show_employee_report";
	}*/
	
	@GetMapping("/report")
	public String showEmployeeReport(Map<String,Object> map) {
		//use service
		Iterable<Employee> itEmps=empService.getAllEmployees();
		//put result in model attribute
		map.put("empsList", itEmps);
		//map.put("resultMsg", msg);
		//return LVN
		return "show_employee_report";
	}
	
	/*@PostMapping("/add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,Map<String,Object> map) {
		System.out.println("EmployeeOperationsController.saveEmployee()");
		//use service
		String msg=empService.registerEmployee(emp);
		//keep the result in ModelAttribute
		map.put("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}*/
	
	/*@PostMapping("/add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,RedirectAttributes attrs) {
		System.out.println("EmployeeOperationsController.saveEmployee()");
		//use service
		String msg=empService.registerEmployee(emp);
		//keep the result as flashAttribute
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}*/
	
	/*
	@PostMapping("/add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,HttpSession ses) {
		System.out.println("EmployeeOperationsController.saveEmployee()");
		//use service
		String msg=empService.registerEmployee(emp);
		//keep the result in session Attribute
		ses.setAttribute("resultMsg", msg);
		return "redirect:report";
	}*/
	
	@PostMapping("/add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,RedirectAttributes attrs) {
		System.out.println("EmployeeOperationsController.saveEmployee()");
		//use service
		String msg=empService.upsertEmployee(emp,"add");
		//keep the result in ModelAttribute
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String editEmployee(@RequestParam("no")int eno,@ModelAttribute("emp")Employee emp) {
		Employee emp1=empService.editEmployee(eno);
		//copy emp data
		BeanUtils.copyProperties(emp1, emp);
		return "edit_employee";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("emp")Employee emp,RedirectAttributes attr) {
		//use service
		String msg=empService.upsertEmployee(emp, "update");
		//keep the result in ModelAttribute
		attr.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("no")int eno,RedirectAttributes attr) {
		String msg=empService.deleteEmployee(eno);
		System.out.println("msg"+msg);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}
	
	@ModelAttribute("de"
			+ "ptNoInfo")
	public List<Integer> refDataFordeptNoSelectBox(){
		//use service
		return empService.fetchAllDeptno();
	}

}
