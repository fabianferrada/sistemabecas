package io.github.fabianferrada.sistemabecas_auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombres;
	private String apellidos;
	private String email;
	private String contrasena;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getNombres() {
		return this.nombres;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getContrasena() {
		return this.contrasena;
	}
}