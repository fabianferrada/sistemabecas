package io.github.fabianferrada.sistemabecas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Estudiante {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nombres;
	private String apellidos;
	private int rut;
	private String email;
	private String contrasena;
	
	// Join tables
	@ManyToMany
	@JoinTable(
		name = "EstudianteRealizaPostulacion",
		joinColumns = @JoinColumn(name = "IdEstudiante"),
		inverseJoinColumns = @JoinColumn(name = "IdPostulacion")
	)
	private Set<Postulacion> postulaciones = new HashSet<>();
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombres() {
		return this.nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public int getRut() {
		return this.rut;
	}
	
	public void setRut(int rut) {
		this.rut = rut;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContrasena() {
		return this.contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Set<Postulacion> getPostulaciones() {
		return this.postulaciones;
	}
}