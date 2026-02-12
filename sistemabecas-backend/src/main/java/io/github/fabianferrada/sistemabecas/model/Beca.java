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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setFechaminimapostulacion(LocalDateTime fecha) {
		this.fechaminimapostulacion = fecha;
	}
	
	public LocalDateTime getFechaminimapostulacion() {
		return this.fechaminimapostulacion;
	}
	
	public void setFechamaximapostulacion(LocalDateTime fecha) {
		this.fechamaximapostulacion = fecha;
	}
	
	public LocalDateTime getFechamaximapostulacion() {
		return this.fechamaximapostulacion;
	}
}