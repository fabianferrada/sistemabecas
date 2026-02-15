package io.github.fabianferrada.sistemabecas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Postulacion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String estado;
	private String comentario;
	
	@OneToOne
	@JoinColumn(name="IdBeca")
	private Beca beca;
	
	@ManyToOne
	@JoinColumn(name="IdEstudiante")
	private Estudiante estudiante;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String getComentario() {
		return this.comentario;
	}
	
	public void setBeca(Beca beca) {
		this.beca = beca;
	}
	
	public Beca getBeca() {
		return this.beca;
	}
	
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public Estudiante getEstudiante() {
		return this.estudiante;
	}
}