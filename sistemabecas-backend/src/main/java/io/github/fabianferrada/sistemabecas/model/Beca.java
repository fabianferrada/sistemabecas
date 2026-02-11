package io.github.fabianferrada.sistemabecas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Beca {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombre;
	private String descripcion;
	LocalDateTime fechaminimapostulacion;
	LocalDateTime fechamaximapostulacion;
}