package com.example.demo;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorEF {
	  @GetMapping("/")
	    public String paso1() {
	        return "paso1";
	    }
	  
	  
	  @PostMapping("/paso2")
	  public String paso2(@RequestParam(name="nombre" , required= false) String nombre ,
			  @RequestParam(name="edad" , required= false) String edad , Model model) {
		  if(nombre.isBlank() || nombre.isEmpty()) {
			  model.addAttribute("error" , "El nombre es obligatorio");
			  return "paso1";
		  }
		  
		  
		  if(edad.isBlank() || edad.isEmpty()) {
			  
			  
			  model.addAttribute("error" , "Introduce un numero ");
			  return "paso1";
		  }
		  
		  model.addAttribute("nombre" , nombre);
		  model.addAttribute("edad" , edad);
		  return "paso2";
	  }
	  
	  
	  @PostMapping("/paso3")
	  public String paso3(@RequestParam(name="nombre" , required= false) String nombre ,
			  @RequestParam(name="edad" , required= false) String edad, 
              @RequestParam(name="turno" , required=false) String turno ,
              Model model) {
		  if(turno == null) {
			  model.addAttribute("error" , "Debes elegir un turno");
			  return "paso2";
		  }
		  model.addAttribute("nombre" , nombre);
		  model.addAttribute("edad" , edad);
		  model.addAttribute("turno" , turno);
		  return "paso3";
	  }
	  
	  
	  @PostMapping("/resultado")
	  public String resultado(@RequestParam(name="nombre" , required= false) String nombre ,
			  @RequestParam(name="edad" , required= false) String edad, 
              @RequestParam(name="turno" , required=false) String turno,
              @RequestParam(name ="actividades" , required = false) List<String> actividades , Model model) {
		  if(actividades == null||actividades.isEmpty() ) {
			  model.addAttribute("error" , "Elige al menos una actividad");
			  return "paso3";
		  }
		  
		  List<String> resumen = new ArrayList<>();
		  resumen.add("Nombre " + nombre);
		  resumen.add("Edad " + edad);
		  resumen.add("Turno " + turno);
		  resumen.add("Actividades " + String.join(", ", actividades));
		  
		  model.addAttribute("resumen" , resumen);
		  return "resultado";
	  }

	  
}
