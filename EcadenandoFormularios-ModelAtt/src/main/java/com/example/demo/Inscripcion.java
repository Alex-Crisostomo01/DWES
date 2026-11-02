package com.example.demo;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Inscripcion {
	
	
	@NotBlank(message="Debes introducir el nombre")
	private String nombre;
	
	@NotNull(message = "Edad obligatoria")
	@Min(value = 5 , message = "Edad minima 6 años")
	@Max(value = 22 , message = "Edad maxima 22 años")
	private Integer edad;
	
	@NotBlank(message = "Debes elegir un turno")
	private String turno;
	
	@NotEmpty(message = "Elegir al menos una actividad")
	private List<String> actividades;
	
	public Inscripcion() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<String> getActividades() {
		return actividades;
	}

	public void setActividades(List<String> actividades) {
		this.actividades = actividades;
	}
	
	
}
