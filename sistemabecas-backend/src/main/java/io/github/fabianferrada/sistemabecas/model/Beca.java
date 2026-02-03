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
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public LocalDateTime getFechaMinimaPostulacion() {
		return this.fechaminimapostulacion;
	}
	
	public void setFechaMinimaPostulacion(LocalDateTime fecha) {
		this.fechaminimapostulacion = fecha;
	}
	
	public LocalDateTime getFechaMaximaPostulacion() {
		return this.fechamaximapostulacion;
	}
	
	public void setFechaMaximaPostulacion(LocalDateTime fecha) {
		this.fechamaximapostulacion = fecha;
	}
}