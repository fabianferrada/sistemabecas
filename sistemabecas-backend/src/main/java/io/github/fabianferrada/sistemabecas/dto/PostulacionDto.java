package io.github.fabianferrada.sistemabecas.dto;

public class PostulacionDto {
	private String estado;
	private String comentario;
	private int idBeca;
	private int idEstudiante;
	
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
	
	public void setIdBeca(int idBeca) {
		this.idBeca = idBeca;
	}
	
	public int getIdBeca() {
		return this.idBeca;
	}
	
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	public int getIdEstudiante() {
		return this.idEstudiante;
	}
}