package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "welcome";
	}
	
	
	/*@GetMapping("/register")
	public String showForm(@ModelAttribute("stud")Student student) {
		//return LVN
		return "student_register";
	}
	*/
	
	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("stud", new Student());
		//return LVN
		return "student_register";
	}
	
	@PostMapping("/register")
	public String processStudent(Map<String,Object> map,@ModelAttribute Student st) {
		System.out.println("Student:: "+st);
		//generate result
		String grade=null;
		if(st.getAvg()>=75)
			grade="First Class with Distinction";
		else if(st.getAvg()>=60)
			grade="First class";
		else if(st.getAvg()>=50)
			grade="Second class";
		else if(st.getAvg()>=35)
			grade="Third class";
		else 
			grade="Fail";
		//keep the result in Model attribute
		map.put("result", grade);
		return "show_result";
	}
	
	/*@GetMapping("/data")
	public String process(@RequestParam("sno") int no,@RequestParam("sname")String name) {
		System.out.println(no+"--"+name);
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public String process(@RequestParam int no,@RequestParam String name) {
		System.out.println(no+"--"+name);
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam String sname) {
		System.out.println(sno+"--"+sname);
		return "show_result";
	}
	*/
	
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam(required=false) String name) {
		System.out.println(sno+"--"+name);
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam(defaultValue ="rrr") String name) {
		System.out.println(sno+"--"+name);
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public String process(@RequestParam(name="sno", required=false)Integer no,
			               @RequestParam("sname")String name,
			               @RequestParam("sadd")String addrs[],
			               @RequestParam("sadd")List<String> saddList,
			               @RequestParam("sadd")Set<String> saddSet
			) {
		System.out.println(no+" - "+name+" - "+Arrays.toString(addrs)+" - "+saddList+" - "+saddSet);
		//return LVN
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public String process(@RequestParam(name="sno", required=false)Integer no,
	                       @RequestParam("sname")String name,
	                       @RequestParam("sadd")String addrs
	                    ) {
		System.out.println(no+" "+name+" "+addrs);
		return "show_result";		
	}*/
	
	@GetMapping("/report")
	public String generateReport(Map<String,Object> map,
			                                 @RequestParam(name="type")String type
			               ) {
		if(type.equalsIgnoreCase("excel"))
			map.put("result", "Excel-Report-Generation");
		
		else if(type.equalsIgnoreCase("pdf"))
			map.put("result", "PDF-Report-Generation");
		return "show_result";
	}
	
}
