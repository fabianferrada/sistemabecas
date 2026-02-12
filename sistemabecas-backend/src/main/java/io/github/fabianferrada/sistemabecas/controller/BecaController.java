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

import io.github.fabianferrada.sistemabecas.dto.StandardResponse;
import io.github.fabianferrada.sistemabecas.model.Beca;
import io.github.fabianferrada.sistemabecas.repository.BecaRepository;

@Controller
@RequestMapping("/api/beca")
public class BecaController {
	@Autowired
	private BecaRepository becaRepository;
	
	@PostMapping("/crear")
	public @ResponseBody Beca crearBeca(@RequestBody Beca beca) {
		return becaRepository.save(beca);
	}
	
	@GetMapping("/listar")
	public @ResponseBody Iterable<Beca> obtenerTodos() {
		return becaRepository.findAll();
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody Beca obtenerBeca(@PathVariable int id) {
		return becaRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/editar/{id}")
	public @ResponseBody Beca editarBeca(@PathVariable int id, @RequestBody Beca beca) {
		becaRepository.deleteById(id);
		return becaRepository.save(beca);
	}
	
	@DeleteMapping("/borrar/{id}")
	public @ResponseBody StandardResponse eliminarBeca(@PathVariable int id) {
		becaRepository.deleteById(id);
		return new StandardResponse(true);
	}
}