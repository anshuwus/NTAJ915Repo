package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ShowHomeController {
	@Autowired
	private ServletContext sc;
	@Autowired
	private ServletConfig cg;
	
	@RequestMapping("/")
	public String showHome() {
		//return LVN
		return "welcome";
	}
	
	/*@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		System.out.println("ShowHomeController.process():: "+map.getClass());
		//add model attributes to shared memory
		map.put("attr1","val1");
		map.put("sysDt", LocalDateTime.now());
		//return LVN
		return "show_data";
	}*/
	
	/*@RequestMapping("/process")
	public String process(Model model) {
		System.out.println("ShowHomeController.process()"+model.getClass());
		//add model attributes to shared memory
		model.addAttribute("attr1", "val1");
		model.addAttribute("sysDt", LocalDateTime.now());
		return "show_data";
	}
	
	@RequestMapping("/process")
	public String process(ModelMap model) {
		System.out.println("ShowHomeController.process()"+model.getClass());
		//add model attributes to shared memory
		model.addAttribute("attr1", "val1");
		model.addAttribute("sysDt", LocalDateTime.now());
		return "show_data";
	}
	
	@RequestMapping("/process")
	public Model process() {
		Model model=new BindingAwareModelMap(); //manually created shared memory
		//add model attributes to shared memory
		model.addAttribute("attr1", "value1");
		model.addAttribute("sysDt", LocalDateTime.now());
		return model;
	}
	
	@RequestMapping("/process")
	public Map<String,Object> process(){
		//create Shared Memory
		Map<String,Object> map=new HashMap();
		//add Model attributes to shared memory
		map.put("attr1", "val1");
		map.put("sysDt", LocalDateTime.now());
		return map;
	}
	
	@RequestMapping("/process")
	public ModelAndView process() {
		//create Shared Memory
		ModelAndView mav=new ModelAndView();
		//add model attributes to shared Memory
		mav.addObject("attr1", "val1");
		mav.addObject("sysDt", LocalDateTime.now());
		//place LVN to MAV object
		mav.setViewName("show_data");
		return mav;
	}
	
	@RequestMapping("/process")
	public String process() {
		System.out.println("ShowHomeController.process()");
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String showReport() {
		System.out.println("ShowHomeController.showReport()");
		return "show_data";
	}
	
	
		@RequestMapping("/process")
		public String process(HttpServletRequest req) {
			System.out.println("ShowHomeController.process()");
			req.setAttribute("attr1", "val1");
			return "redirect:report";
		}
		
		@RequestMapping("/report")
		public String showReport(HttpServletRequest req) {
			System.out.println("ShowHomeController.showReport()"+req.getAttribute("attr1"));
			req.getAttribute("attr1");
			return "show_data";
		}
	
	@RequestMapping("/process")
	public String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("ShowHomeController.process()"+req.hashCode());
		req.setAttribute("attr1", "value1");
		return "show_data";
	}
	
	  @RequestMapping("/process")
	  public String process(HttpSession ses) {
		  ses.setAttribute("attr1", "value1");
		  return "show_data";
	  }
	 
	 @RequestMapping("/process")
	 public String process(Map<String,Object> map) {
	  System.out.println("web application context path:: "+sc.getContextPath());
	  System.out.println("DS Logical name:: "+cg.getServletName());
	  map.put("attr1", "val1");
	  return "show_data";
	 }*/
	
	  
	  @RequestMapping("/process")
	  public void process(HttpServletResponse res) throws IOException {
		  //get PrintWriter object
		  PrintWriter pw=res.getWriter();
		  //set response contentType
		  res.setContentType("text/html");
		  //write data to browser s/w
		  pw.println("<b>Directly from Handler method</b>");
	  }
	  
	  
}
