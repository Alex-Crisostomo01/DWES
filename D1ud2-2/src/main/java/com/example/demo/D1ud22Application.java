package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@SpringBootApplication
@Controller
public class D1ud22Application {

	public static void main(String[] args) {
		SpringApplication.run(D1ud22Application.class, args);
	}
	  @GetMapping("/hola")
	    public String hello(@RequestParam(value = "nombre", defaultValue = "Mundo") String nombre , @RequestParam(value ="edad")  int edad) {
		      return String.format("Hola <b> %s! </b> es esta tu edad %d", nombre , edad );
	    }
	  @PostMapping("/hola")
	  @ResponseBody
	    public String holaPost(@RequestParam(value = "nombre", defaultValue = "Mundo") String nombre ,@RequestParam(value ="edad")  int edad) {
	      return String.format("Hola  %s!  es esta tu edad %d", nombre , edad );
	    }
}
