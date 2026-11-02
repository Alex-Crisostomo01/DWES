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
	public String dameInicio(Model model) {
		model.addAttribute("inscripcion" , new Inscripcion());
		return "paso1";
	}

	
// Ir hacia atras
	
	@PostMapping("/volver1")
	public String volver1(@ModelAttribute Inscripcion inscripcion){
		return "paso1";
	}
	@PostMapping("/volver2")
	public String volver2(@ModelAttribute Inscripcion inscripcion){
		return "paso2";
	}
	@PostMapping("/volver3")
	public String volver3(@ModelAttribute Inscripcion inscripcion){
		return "paso3";
	}
	
	
	
	
	
	
// Ir hacia delante 
	@PostMapping("/paso2")
	public String paso2(@Valid @ModelAttribute Inscripcion inscripcion , BindingResult br) {
		if (br.hasFieldErrors("nombre") || br.hasFieldErrors("edad")) {
			return "paso1";
		}
		
		return "paso2";
	}
	
	
	@PostMapping("/paso3")
	public String paso3(@Valid @ModelAttribute Inscripcion inscripcion , BindingResult br) {
		if(br.hasFieldErrors("turno")) {
			return "paso2";
		}
		return "paso3";
	}
	
	
	@PostMapping("/resultado")
	public String resultado(@Valid @ModelAttribute Inscripcion inscripcion , BindingResult br , Model model) {
		
		if(br.hasFieldErrors("actividades")) {
			return "paso3";
		}
		
		 List<String> resumen = new ArrayList<>();
		  resumen.add("Nombre " + inscripcion.getNombre());
		  resumen.add("Edad " + inscripcion.getEdad());
		  resumen.add("Turno " + inscripcion.getTurno());
		  resumen.add("Actividades " + String.join(", ", inscripcion.getActividades()));
		  
		  model.addAttribute("resumen" , resumen);
		
		return "resultado";
	}
}
