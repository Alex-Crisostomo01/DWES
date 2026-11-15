package com.example.demo;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ControladorCookies {

	
	
	@GetMapping("/")
	public String inicio() {
		return "paso1";
	}
	
	 @PostMapping("/paso1")
	    public String procesarPaso1(@RequestParam("nombre") String nombre,
	                                @RequestParam("email") String email,
	                                HttpServletResponse response) {
		 	guardarCookie(response, "nombre", nombre);
	        guardarCookie(response, "email", email);
	        return "paso2";
	    }
	 
	 
	 @PostMapping("/paso2")
	 public String procesarPaso2(@CookieValue(name = "nombre", required = false) String nombre,
	                             @RequestParam("ciudad") String ciudad,
	                             @RequestParam("telefono") String telefono,
	                             HttpServletResponse response) {
	     
	     if (nombre == null) {
	         return "paso1";
	     }
	     guardarCookie(response, "ciudad", ciudad);
	     guardarCookie(response, "telefono", telefono);
	     return "paso3";
	 }
	 
	 @PostMapping("/paso3")
	 public String procesarPaso3(@CookieValue(name = "nombre", required = false) String nombre,
	                             @CookieValue(name = "email", required = false) String email,
	                             @CookieValue(name = "ciudad", required = false) String ciudad,
	                             @CookieValue(name = "telefono", required = false) String telefono,
	                             @RequestParam("color") String color,
	                             @RequestParam("comentario") String comentario,
	                             HttpServletResponse response,
	                             Model model) {

	    
	     if (nombre == null || ciudad == null) {
	         return "paso1";
	     }

	     
	     guardarCookie(response, "color", color);
	     guardarCookie(response, "comentario", comentario);

	    
	     model.addAttribute("nombre", decodificar(nombre));
	     model.addAttribute("email", decodificar(email));
	     model.addAttribute("ciudad", decodificar(ciudad));
	     model.addAttribute("telefono", decodificar(telefono));
	     model.addAttribute("color", color);
	     model.addAttribute("comentario", comentario);

	     return "resumen";
	 }

	 private String decodificar(String valor) {
	     if (valor == null) {
	         return null;
	     }
	     return URLDecoder.decode(valor, StandardCharsets.UTF_8);
	 }
	 
	 private void guardarCookie(HttpServletResponse response, String clave, String valor) {
		    String valorCodificado = URLEncoder.encode(valor, StandardCharsets.UTF_8);
		    Cookie cookie = new Cookie(clave, valorCodificado);
		    cookie.setPath("/");
		    cookie.setMaxAge(60 * 30);
		    response.addCookie(cookie); 
		}
}
