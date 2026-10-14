package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class ControladorPokemon {
	@GetMapping("/formPokemon")
	public String mostrar(Model model) {
		model.addAttribute("pokemon" , new Pokemon());
		return "formPokemon";
	}
	
	@PostMapping("/formPokemon")
	public String procesarForm(@Valid Pokemon poke , BindingResult b , Model model ) {
		
		if(b.hasErrors()) {
			return "formPokemon";
		}
	
		
		
		return "resumenPokemon";
	}
}
