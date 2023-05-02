package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService empService;
	@Autowired
	private EmployeeValidator empValidator;
	
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
	
	@PostMapping("/add")  //form submission related to add employees operation
	public String saveEmployee(@ModelAttribute("emp")Employee emp,RedirectAttributes attrs,BindingResult erros) {
		System.out.println("EmployeeOperationsController.saveEmployee()");
		
		//Enable server form validations only when client side form validations are not done
		if(emp.getVflag().equalsIgnoreCase("no")) {
			System.out.println("Server side Form validations");
			//use validator
			if(empValidator.supports(Employee.class)) {
				empValidator.validate(emp, erros);
				

				//Application logic errors
				if(empService.IsDesgInRejectedList(emp.getJob()))
					erros.rejectValue("job", "emp.desg.reject");
				
				
				if(erros.hasErrors()) //if form validation error messages are found
					return "register_employee";
			}
		}
		
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
	
	@PostMapping("/update") //handler method to submit edit Employee form page
	public String updateEmployee(@ModelAttribute("emp")Employee emp,RedirectAttributes attr,BindingResult errors) {
		
		//enable Server form validations only when client side form validations are not done
		if(emp.getVflag().equalsIgnoreCase("no")) {
			System.out.println("Server side form validations");
			//use validator
			if(empValidator.supports(Employee.class)) {
				empValidator.validate(emp, errors);
				
				//Application logic errors
				if(empService.IsDesgInRejectedList(emp.getJob()))
					errors.rejectValue("job", "emp.desg.reject");
				
				if(errors.hasErrors()) //if form validation error messages are found
					return "edit_employee";
			}
		}
		
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
	
	@ModelAttribute("deptNoInfo")
	public List<Integer> refDataFordeptNoSelectBox(){
		//use service
		return empService.fetchAllDeptno();
	}

	
	//Pagination
	@GetMapping("/paginationReport")
	public String showEmployeeReport(@PageableDefault(page = 0,size=5,sort = "job",direction =Sort.Direction.ASC )Pageable pageable,
			                           Map<String,Object> map) {
		//use service
		Page<Employee> page=empService.getEmployeeReportDataByPage(pageable);
		//put result in model attribute
		map.put("empData", page);
		
		//return LVN
		return "show_employeePagination_report_";
	}
}
