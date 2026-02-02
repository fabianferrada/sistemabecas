package io.github.fabianferrada.sistemabecas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import io.github.fabianferrada.sistemabecas.dto.StandardResponse;
import io.github.fabianferrada.sistemabecas.model.Estudiante;
import io.github.fabianferrada.sistemabecas.repository.EstudianteRepository;

@Controller
@RequestMapping("/api/estudiante")
public class EstudianteController {
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody Estudiante obtenerPorId(@PathVariable int id) {
		return estudianteRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/listar")
	public @ResponseBody Iterable<Estudiante> obtenerTodos() {
		return estudianteRepository.findAll();
	}
	
	@PostMapping("/crear")
	public @ResponseBody Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}
	
	@PutMapping("/actualizar/{id}")
	public @ResponseBody Estudiante actualizarEstudiante(
		@PathVariable int id,
		@RequestBody Estudiante estudiante
	) {
		estudianteRepository.deleteById(id);
		return estudianteRepository.save(estudiante);
	}
	
	@DeleteMapping("/borrar/{id}")
	public @ResponseBody StandardResponse borrarEstudiante(@PathVariable int id) {
		estudianteRepository.deleteById(id);
		return new StandardResponse(true);
	}
}