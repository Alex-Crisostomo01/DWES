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
	public String inicio(HttpSession sesion , Model model) {
		
		if(sesion.getAttribute("usuario") != null) {
			model.addAttribute("pagina" , "inicio");
			model.addAttribute("nombre" , sesion.getAttribute("usuario"));
			return "privada";
		}
		
		return "redirect:/login";
		
		
		
	}
	@GetMapping("/pagina1")
	public String pagina1(HttpSession sesion  , Model model) {
		if(sesion.getAttribute("usuario") != null) {
			model.addAttribute("pagina" , "pagina1");
			model.addAttribute("nombre" , sesion.getAttribute("usuario"));
			return "privada";
		}
		
		return "redirect:/login";
		
	}
	@GetMapping("/pagina2")
	public String pagina2(HttpSession sesion , Model model) {
		if(sesion.getAttribute("usuario") != null) {
			model.addAttribute("pagina" , "pagina2");
			model.addAttribute("nombre" , sesion.getAttribute("usuario"));
			return "privada";
		}
		
		return "redirect:/login";
		
	}
	@GetMapping("/login")
	public String login(HttpSession sesion , Model model) {
		if(sesion.getAttribute("usuario") != null) {
			model.addAttribute("pagina" , "Inicio");
			model.addAttribute("nombre" , sesion.getAttribute("usuario"));
			return "privada";
		}
		
		
		return "login";
	}
	
	@PostMapping("/login")
	public String compruebaSession(@RequestParam(name ="usuario") String usuario ,
			@RequestParam(name = "passwd") String passwd , HttpSession sesion , 
			Model model) {
		if(usuario.equals(USUARIO) && passwd.equals(PASSWD)) {
			sesion.setAttribute("usuario", usuario);
			return "redirect:/";
		}
		model.addAttribute("error" , "Usuario o contraseña invalida");
		return "login";
	}
	
	@PostMapping("/logout")
	public String cerrarSesion(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/login";
	}
}
