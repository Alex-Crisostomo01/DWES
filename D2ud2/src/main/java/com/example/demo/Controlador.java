package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class Controlador {

	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@Valid @ModelAttribute Greeting greeting, BindingResult bindingResult ,Model model) {
		
		if(bindingResult.hasErrors()) {
			return "greeting";
		}
		
		model.addAttribute("greeting", greeting);
		return "result";
	}

}
