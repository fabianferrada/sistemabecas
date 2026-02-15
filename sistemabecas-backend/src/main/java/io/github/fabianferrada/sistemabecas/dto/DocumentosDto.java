package io.github.fabianferrada.sistemabecas.dto;

public class DocumentosDto {
	private String nombre;
	private String descripcion;
	
	private int idBeca;
	
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
	
	public void setIdBeca(int idBeca) {
		this.idBeca = idBeca;
	}
	
	public int getIdBeca() {
		return this.idBeca;
	}
}