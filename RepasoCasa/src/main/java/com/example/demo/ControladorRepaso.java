package com.example.demo;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorRepaso {
	
	
	
	@GetMapping("/saludo")
	public String dameInicio(@RequestParam(name= "nombre" , defaultValue ="invitado") String nombre , Model model) {
		model.addAttribute("nombre", nombre);
		return "saludo";
	}
	
	
	@GetMapping("/producto/{id}")
	public String verProducto(@PathVariable("id") int id  ,   Model model) {
		
		List<Producto> listaProductos = List.of(new Producto("raton" , 13.50), new Producto("mesa" ,180) , new Producto("teclado" , 25.50)) ;
		model.addAttribute("productos" ,listaProductos);
		model.addAttribute("id" , id);
		return "producto";
	}
	
	
	@GetMapping("/persona")
	public String crearUsuario(Model model) {
		model.addAttribute("persona" , new Persona());
		
		return "persona";
		
	}
	@PostMapping("/resultado")
	public String mandaPersona(Persona persona, Model model) {
		
		model.addAttribute("persona" , persona);
		
		return "resultado";
	}
}
