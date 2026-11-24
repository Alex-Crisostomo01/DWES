package org.goya.daw2.dwes.d3_ud3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
	   @GetMapping({"/", "/home"})
	    public String home() {
	        return "home";    // home.html
	    }

	    @GetMapping("/login")
	    public String login() {
	        return "login";   // login.html con el formulario
	    }

	    @GetMapping("/hello")
	    public String hello() {
	        return "hello";   // hello.html (solo si has iniciado sesión)
	    }
	}