package io.github.fabianferrada.sistemabecas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class DocumentoDePostulacion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String url;
	
	@ManyToOne
	@JoinColumn(name="IdPostulacion")
	private Postulacion postulacion;
	
	@OneToOne
	@JoinColumn(name="IdDocumento")
	private Documentos documento;
}