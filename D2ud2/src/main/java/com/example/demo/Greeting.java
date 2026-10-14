package com.example.demo;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Greeting {
	@NotNull
	@Min(1)
	private long id;
	@NotBlank(message = "El contenido no puede estar vacío")
	@Size(max = 20, message = "El contenido no puede superar los 200 caracteres")
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
