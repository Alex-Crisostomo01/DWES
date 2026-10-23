package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
	 @GetMapping("/hola")
	    public String hello(@RequestParam(value = "nombre", defaultValue = "World") String nombre) {
	      return String.format("Hola %s!", nombre);
	    }
	 @PostMapping("/hola")
	 	public String recibeNombre(@RequestParam(value = "nombre", defaultValue = "World") String nombre) {
		      return String.format("Hola %s!", nombre);
		    }
	 }

