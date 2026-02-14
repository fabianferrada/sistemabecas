package io.github.fabianferrada.sistemabecas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.fabianferrada.sistemabecas.model.Administrador;
import io.github.fabianferrada.sistemabecas.repository.AdministradorRepository;

@Controller
@RequestMapping("/api/administrador")
public class AdministradorController {
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody Administrador obtenerAdministrador(@PathVariable int id) {
		return administradorRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/actualizar/{id}")
	public @ResponseBody Administrador actualizarAdministrador(
		@PathVariable int id, @RequestBody Administrador administrador
	) {
		administradorRepository.deleteById(id);
		return administradorRepository.save(administrador);
	}
}