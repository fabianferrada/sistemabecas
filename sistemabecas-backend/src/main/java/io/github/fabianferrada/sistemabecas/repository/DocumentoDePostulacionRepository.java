package io.github.fabianferrada.sistemabecas.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.fabianferrada.sistemabecas.model.DocumentoDePostulacion;

public interface DocumentoDePostulacionRepository
	extends CrudRepository<DocumentoDePostulacion, Integer>
{
	
}