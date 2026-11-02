package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class Controlador {
		
	
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("animal" , new Animal());
		return "formDueño";
	}
	
	
	@PostMapping("/volver1")
	public String volver1(@ModelAttribute Animal animal) {
		return "formDueño";
	}
	
	@PostMapping("/volver2")
	public String volver2(@ModelAttribute Animal animal) {
		return "formMascota";
	}
	
	@PostMapping("/volver3")
	public String volver3(@ModelAttribute Animal animal) {
		return "formCita";
	}
	
	
	
	
	
	@PostMapping("/formMascota")
	public String mascota(@Valid @ModelAttribute Animal animal , BindingResult br) {
		if(br.hasFieldErrors("dueño") || br.hasFieldErrors("telefono")) {
			return "formDueño";
		}
		
		return "formMascota";
	}
	
	@PostMapping("/formCita")
	public String cita( @Valid @ModelAttribute Animal animal ,  BindingResult br) {
		if(br.hasFieldErrors("nombre") || br.hasFieldErrors("raza")) {
			return "formMascota";
		}
		
		
		return "formCita";
	}
	
	@PostMapping("/resultado")
	public String resultados(@Valid @ModelAttribute Animal animal , BindingResult br , Model model) {
		if(br.hasFieldErrors("servicio") || br.hasFieldErrors("urgencia")) {
			return "formCita";
		}
		
		
		
		List<String> resumen = new ArrayList<>();
		
		
		resumen.add("Nombre del dueño : " + animal.getDueño());
		resumen.add("Telefono del dueño : " + animal.getTelefono());
		resumen.add("Nombre de la mascota : " + animal.getNombre());
		resumen.add("Servicio : " + animal.getServicio());
		resumen.add("Nivel de urgencia : " + animal.getUrgencia());
		
		model.addAttribute("resumen" , resumen);
		
		return "resultado";
	}
}
