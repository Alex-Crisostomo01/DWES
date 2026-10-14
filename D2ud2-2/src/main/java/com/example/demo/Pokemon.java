package com.example.demo;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Pokemon {
	@NotBlank(message= "No puede estar el nombre en blanco")
	@Size(min= 3 , max= 20 ,  message ="Debe de tener entre 3-20 caracteres")
	private String nombre;
	@NotNull(message= "Debes seleccionar una evolucion")
	private String evolucion;
	@NotEmpty(message ="Debes seleccionar al menos un mensaje ")
	private List<String> ataques;
	
	
	public Pokemon() {}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEvolucion() {
		return evolucion;
	}

	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}

	public List<String> getAtaques() {
		return ataques;
	}

	public void setAtaques(List<String> ataques) {
		this.ataques = ataques;
	}
	
	
}
