package com.example.demo;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;

public class Animal {

	
	@NotBlank(message = "El nombre del dueño no puede estar vacio")
	private String dueño;
	
	
	@Size(min= 9 ,  max =9, message = "Tienen que ser 9 digitos")
	
	private String telefono;
	
	
	@NotBlank(message = "No puede estar vacio ")
	@Size(max= 20, message = "Debe tener menos de 20 digitos")
	private String nombre;
	
	@NotEmpty(message = "Tienes que elegir una raza de animal")
	private String raza;
	
	@NotEmpty(message = "Tienes que elegir al menos un servicio")
	private List<String> servicio;
	
	@NotBlank(message = "Elige una urgencia ")
	private String urgencia;

	public String getDueño() {
		return dueño;
	}

	public void setDueño(String dueño) {
		this.dueño = dueño;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public List<String> getServicio() {
		return servicio;
	}

	public void setServicio(List<String> servicio) {
		this.servicio = servicio;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}
	
	
	
	
}
