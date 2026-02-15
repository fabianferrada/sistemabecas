package io.github.fabianferrada.sistemabecas.dto;

public class ApelacionDto {
	private String titulo;
	private String descripcion;
	private int idEstudiante;
	private int idPostulacion;
	
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
	
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	public int getIdEstudiante() {
		return this.idEstudiante;
	}
	
	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	
	public int getIdPostulacion() {
		return this.idPostulacion;
	}
}