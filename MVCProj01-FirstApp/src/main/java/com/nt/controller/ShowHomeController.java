package com.nt.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {
	
	@RequestMapping("/home")
	public String showHome() {
		//return LVN
		return "welcome";
	}
	/*
	@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		System.out.println("ShowHomeController.process():: "+map.getClass());
		//add model attributes to shared memory
		map.put("attr1","val1");
		map.put("sysDt", LocalDateTime.now());
		//return LVN
		return "show_data";
	}*/
	
	@RequestMapping("/process")
	public String process(Model model) {
		System.out.println("ShowHomeController.process()"+model.getClass());
		//add model attributes to shared memory
		model.addAttribute("attr1", "val1");
		model.addAttribute("sysDt", LocalDateTime.now());
		return "show_data";
	}
	/*
	@RequestMapping("/process")
	public String process(ModelMap model) {
		System.out.println("ShowHomeController.process()"+model.getClass());
		//add model attributes to shared memory
		model.addAttribute("attr1", "val1");
		model.addAttribute("sysDt", LocalDateTime.now());
		return "show_data";
	}*/
	
	
}

