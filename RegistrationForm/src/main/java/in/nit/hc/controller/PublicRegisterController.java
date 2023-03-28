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

import in.nit.hc.entity.PublicRegister;
import in.nit.hc.service.IPublicRegisterService;
import in.nit.hc.service.IUserTypeService;

@Controller
@RequestMapping("/user")
public class PublicRegisterController {
	@Autowired
	private IPublicRegisterService service;
	
	@Autowired
	private IUserTypeService userService;
	
	private void createDynamicUi(Model model) {
		model.addAttribute("userType", userService.getTypeCodeAndUserType());
	}
	//1. show register page
	@GetMapping("/register")
	public String displayRegister(@RequestParam(value="message",required=false)String message,Model model) {
		model.addAttribute("message", message);
		createDynamicUi(model);
		return "PublicRegister";
	}
	
	//2. save data on submit
	@PostMapping("/save")
	public String save(@ModelAttribute PublicRegister user, RedirectAttributes attributes) {
		Long id=service.savePublicCredentials(user);
		attributes.addAttribute("message", "User Registered Successfully!");
		return "redirect:register";
	}
}
