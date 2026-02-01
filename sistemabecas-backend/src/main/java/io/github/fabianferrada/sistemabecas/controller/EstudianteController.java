package io.github.fabianferrada.sistemabecas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.fabianferrada.sistemabecas.model.Estudiante;
import io.github.fabianferrada.sistemabecas.repository.EstudianteRepository;

@Controller
@RequestMapping("/api/estudiante")
public class EstudianteController {
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@GetMapping("/{id}")
	public @ResponseBody Estudiante obtenerPorId(@PathVariable int id) {
		return estudianteRepository.findById(id).orElse(null);
	}
}