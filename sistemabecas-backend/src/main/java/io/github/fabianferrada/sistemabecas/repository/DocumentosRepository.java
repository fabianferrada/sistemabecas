package io.github.fabianferrada.sistemabecas.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import io.github.fabianferrada.sistemabecas.model.Documentos;

public interface DocumentosRepository extends CrudRepository<Documentos, Integer> {
	public List<Documentos> findByBecaId(int idBeca);
}