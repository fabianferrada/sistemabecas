package io.github.fabianferrada.sistemabecas_auth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.github.fabianferrada.sistemabecas_auth.model.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, Integer> {
	public List<Administrador> findByEmail(String email);
}