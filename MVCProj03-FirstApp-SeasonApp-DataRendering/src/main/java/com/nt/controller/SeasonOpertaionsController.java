package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.ISeasonFinderService;

@Controller
public class SeasonOpertaionsController {
	@Autowired
	private ISeasonFinderService service;
	
	@RequestMapping("/")
	public String showHome() {
		return "welcome";
		
	}
	
	@RequestMapping("/season")
	public String showSeason(Map<String,Object> map) {
		//use service
		String msg=service.findSeason();
		//keep  results in Model attributes
		map.put("resultMsg", msg);
		return "display";
	}
	
	@GetMapping("/report")
	public String showMapping() {
		System.out.println("SeasonOpertaionsController.showMapping()");
		return "show_data";
	}
	
	@PostMapping("/report")
	public String showMapping1() {
		System.out.println("SeasonOpertaionsController.showMapping1()");
		return "show_data1";
	}
	
}

