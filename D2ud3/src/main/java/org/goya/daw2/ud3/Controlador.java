package org.goya.daw2.ud3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpSession;
@Controller
public class Controlador {
	private static final String USUARIO = "alexDev";
	private static final String PASSWD = "goya2026";
	
	
	
	@GetMapping("/")
	public String inicio(HttpSession sesion ,  Model model) {
		
		if(sesion.getAttribute("usuario") == null || sesion.getAttribute("passwd") == null) {
			
			return "login";
		}
		if(!sesion.getAttribute("usuario").equals(USUARIO) || !sesion.getAttribute("passwd").equals(PASSWD)) {
			return "login";
		
		}
		
		return "inicio";
	}
	
	@PostMapping("/login")
	public String mandaLogin(@RequestParam(name = "usuario" , required= false) String usuario ,
			@RequestParam(name = "passwd" , required= false) String passwd ,  HttpSession sesion ,  Model model) {
		sesion.setAttribute("usuario", usuario);
		sesion.setAttribute("passwd", passwd);
		
		return "pagina1";
	}
}
