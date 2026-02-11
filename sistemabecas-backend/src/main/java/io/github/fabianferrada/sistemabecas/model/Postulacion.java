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
}