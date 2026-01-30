package io.github.fabianferrada.sistemabecas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
	@GetMapping("/{id}")
	public int obtenerPorId(@PathVariable int id) {
		return id;
	}
}