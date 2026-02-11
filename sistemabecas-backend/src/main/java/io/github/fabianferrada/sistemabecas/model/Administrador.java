package io.github.fabianferrada.sistemabecas.model;

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
}