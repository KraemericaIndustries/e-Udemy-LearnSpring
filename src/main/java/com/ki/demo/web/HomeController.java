package com.ki.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.ki.demo.domain.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "index";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String processFormData(User user) {
		return "result";
	}
}