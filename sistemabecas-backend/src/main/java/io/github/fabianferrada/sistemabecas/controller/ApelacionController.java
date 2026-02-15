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

import io.github.fabianferrada.sistemabecas.dto.ApelacionDto;
import io.github.fabianferrada.sistemabecas.dto.StandardResponse;
import io.github.fabianferrada.sistemabecas.model.Apelacion;
import io.github.fabianferrada.sistemabecas.repository.ApelacionRepository;
import io.github.fabianferrada.sistemabecas.repository.EstudianteRepository;
import io.github.fabianferrada.sistemabecas.repository.PostulacionRepository;

@Controller
@RequestMapping("/api/apelacion")
public class ApelacionController {
	@Autowired
	private ApelacionRepository apelacionRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private PostulacionRepository postulacionRepository;
	
	@PostMapping("/crear")
	public @ResponseBody Apelacion crearApelacion(@RequestBody ApelacionDto apelacionDto) {
		Apelacion apelacion = new Apelacion();
		
		apelacion.setTitulo(apelacionDto.getTitulo());
		apelacion.setDescripcion(apelacionDto.getDescripcion());
		apelacion.setEstudiante(estudianteRepository
			.findById(apelacionDto.getIdEstudiante()).orElse(null));
		apelacion.setPostulacion(postulacionRepository
			.findById(apelacionDto.getIdPostulacion()).orElse(null));
			
		return apelacionRepository.save(apelacion);
	}
	
	@GetMapping("/listar")
	public @ResponseBody Iterable<Apelacion> listarApelaciones() {
		return apelacionRepository.findAll();
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody Apelacion obtenerApelacion(@PathVariable int id) {
		return apelacionRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/editar/{id}")
	public @ResponseBody Apelacion editarApelacion(
		@PathVariable int id, @RequestBody ApelacionDto apelacionDto
	) {
		Apelacion apelacion = apelacionRepository.findById(id).orElse(null);
		
		apelacion.setTitulo(apelacionDto.getTitulo());
		apelacion.setDescripcion(apelacionDto.getDescripcion());
		
		return apelacionRepository.save(apelacion);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody StandardResponse eliminarApelacion(@PathVariable int id) {
		apelacionRepository.deleteById(id);
		
		return new StandardResponse(true);
	}
}