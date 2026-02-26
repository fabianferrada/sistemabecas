package io.github.fabianferrada.sistemabecas_auth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.github.fabianferrada.sistemabecas_auth.model.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {
	public List<Estudiante> findByEmail(String email);
}