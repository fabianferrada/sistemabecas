package io.github.fabianferrada.sistemabecas.dto;

public class DocumentosDePostulacionDto {
	private String url;
	
	int idPostulacion;
	int idDocumento;
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	
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