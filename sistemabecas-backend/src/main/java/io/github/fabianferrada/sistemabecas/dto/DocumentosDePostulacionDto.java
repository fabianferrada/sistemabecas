package io.github.fabianferrada.sistemabecas.dto;

public class DocumentosDePostulacionDto {
	int idPostulacion;
	int idDocumento;
	
	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	
	public int getIdPostulacion() {
		return this.idPostulacion;
	}
	
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	
	public int getIdDocumento() {
		return this.idDocumento;
	}
}