package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.constraints.NotBlank;

@Controller

public class ControladorQuizz {
	
	@GetMapping("/")
	public String inicio(Model model) {
		return "etapa1";
	}
	
	@PostMapping("/etapa2")
	public String etapa2(@RequestParam(name = "nombre", required = false)  String nombre , @RequestParam(name = "apellido", required = false) String apellido , Model model) {
		if (nombre == null || nombre.isBlank() || apellido == null || apellido.isBlank()) {
            model.addAttribute("error", "Por favor, rellenar tanto el nombre como el apellido.");
            
            model.addAttribute("nombre", nombre);
            model.addAttribute("apellido", apellido);
            return "etapa1"; 
        }

        
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        return "etapa2";
	}
	
	@PostMapping("/etapa3")
	public String etapa3(@RequestParam(name = "nombre", required = false)  String nombre , @RequestParam(name = "apellido", required = false) String apellido , @RequestParam(name= "color", required = false) String color ,  Model model) {
		model.addAttribute("nombre" , nombre);
		model.addAttribute("apellido" , apellido);
		if(color == null || color.isBlank()) {
			model.addAttribute("error" , "Selecciona un color o no podras pasar de etapa");
			return "etapa2";
		}
		model.addAttribute("color" , color);
		
		
		return "etapa3";
	}
	
	
	@PostMapping("/etapaFinal")
	public String etapaFinal(@RequestParam(name = "nombre", required = false)  String nombre , @RequestParam(name = "apellido", required = false) String apellido , 	@RequestParam(name= "color", required = false) String color , @RequestParam(name = "tecnologias", required = false) List<String> tecnologias ,  Model model) {
		
		
		
		List<String> datos = new ArrayList<>();
		
		datos.add("Nombre : " + nombre + " " + apellido);
		datos.add("Color favorito : " + color);
		String tech = (tecnologias!= null && !tecnologias.isEmpty()) ? String.join(",", tecnologias) : "Ninguna seleccionada";
		datos.add("Tecnologias seleccionada : " + tech);
		
		
		model.addAttribute("listaDatos" , datos);
		
		return "etapaFinal";
	}
}
