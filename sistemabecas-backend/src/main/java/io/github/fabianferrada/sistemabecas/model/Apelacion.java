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
}