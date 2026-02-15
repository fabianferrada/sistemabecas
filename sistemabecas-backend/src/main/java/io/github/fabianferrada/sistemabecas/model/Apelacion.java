package io.github.fabianferrada.sistemabecas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Apelacion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String titulo;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="IdEstudiante")
	private Estudiante estudiante;
	
	@OneToOne
	@JoinColumn(name="IdPostulacion")
	private Postulacion postulacion;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public Estudiante getEstudiante() {
		return this.estudiante;
	}
	
	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}
	
	public Postulacion getPostulacion() {
		return this.postulacion;
	}
}