package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorContador {
	static AtomicInteger contador = new AtomicInteger(0);
	
	@GetMapping("/")
	public String contador() {
		return "" + contador.addAndGet(1);
	}
}
