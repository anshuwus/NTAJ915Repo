package in.nit.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nit.hc.entity.UserType;
import in.nit.hc.service.IUserTypeService;

@Controller
@RequestMapping("/userType")
public class UserTypeController {
	@Autowired
	private IUserTypeService service;
	
	//1. show register page
	@GetMapping("/register")
	public String displayRegister(@RequestParam(value="message", required=false)String message,Model model) {
		model.addAttribute("message", message);
		return "UserTypeRegister";
	}
	
	//2. save on submit
	@PostMapping("/save")
	public String save(@ModelAttribute UserType user,RedirectAttributes attributes) {
		Long id=service.saveUserType(user);
		attributes.addAttribute("message", "User Role is created with id no: "+id);
		return "redirect:register";
	}
}
