package com.example.demo;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorD4 {

	
	@GetMapping("/")
	public String Inicio(Model model) {
		
		String caracteresEspeciales = "España / \\  \"";
		String apellido = "Crisóstomo";
		
		String nombreCodificado = URLEncoder.encode(caracteresEspeciales , StandardCharsets.UTF_8);
		String apellidoCodificado = URLEncoder.encode(apellido , StandardCharsets.UTF_8);
		
		model.addAttribute("nombreCodificado",nombreCodificado);
		model.addAttribute("apellidoCodificado" , apellidoCodificado);
		
		return "form";
	}
	
	
	@GetMapping("/resultado")
	public String mostrarResultado(@RequestParam(name ="nombre") String nombre , @RequestParam(name = "apellido") String apellido , Model model ) {
		
		model.addAttribute("nombre" , nombre);
		model.addAttribute("apellido" , apellido);
		return "resultado";
	}
	
	@PostMapping("/resultado")
	public String mostrarResultadoPost(@RequestParam(name = "nombre") String nombre, 
	                                   @RequestParam(name = "apellido") String apellido, 
	                                   Model model) {
	    model.addAttribute("nombre", nombre);
	    model.addAttribute("apellido", apellido);
	    return "resultado";
	}
}
