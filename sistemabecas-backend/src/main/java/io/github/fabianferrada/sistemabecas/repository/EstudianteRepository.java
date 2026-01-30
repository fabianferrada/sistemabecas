package io.github.fabianferrada.sistemabecas.repository;
import org.springframework.data.repository.CrudRepository;

import io.github.fabianferrada.sistemabecas.model.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {
	
}