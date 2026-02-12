package io.github.fabianferrada.sistemabecas.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.fabianferrada.sistemabecas.model.Beca;

public interface BecaRepository extends CrudRepository<Beca, Integer> {
	
}