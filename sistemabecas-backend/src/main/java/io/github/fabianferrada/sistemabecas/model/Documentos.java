package io.github.fabianferrada.sistemabecas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Documentos {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombre;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="IdBeca")
	private Beca beca;
}