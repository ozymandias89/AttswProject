package com.example.tddfirst.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tddfirst.entities.Medico;



@Controller
public class LoginController {

	@GetMapping("/login")
	public String greetingForm(Model model) {
		model.addAttribute("medico", new Medico());
		return "login";
	}

	@PostMapping("/login")
	public String greetingSubmit(@ModelAttribute Medico medico, Model model) {
		model.addAttribute("medico", medico);
		return "result";
	}

}
