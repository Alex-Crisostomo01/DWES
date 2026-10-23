package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ControladorWeb {
	@GetMapping("/")
	public String holaMundo(@RequestParam(name="nombre", defaultValue = "Mundo") String nombre , @RequestParam(name="apellido" , defaultValue = "Cruel")String apellido ,  Model model) {
		model.addAttribute( "nombre", nombre);
		model.addAttribute("apellido" , apellido);
		return "holaMundo";
	}
}
