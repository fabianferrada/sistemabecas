package io.github.fabianferrada.sistemabecas.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.fabianferrada.sistemabecas.model.Postulacion;

public interface PostulacionRepository extends CrudRepository<Postulacion, Integer> {
	
}