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

import io.github.fabianferrada.sistemabecas.dto.PostulacionDto;
import io.github.fabianferrada.sistemabecas.dto.StandardResponse;
import io.github.fabianferrada.sistemabecas.model.Beca;
import io.github.fabianferrada.sistemabecas.model.Estudiante;
import io.github.fabianferrada.sistemabecas.model.Postulacion;
import io.github.fabianferrada.sistemabecas.repository.BecaRepository;
import io.github.fabianferrada.sistemabecas.repository.EstudianteRepository;
import io.github.fabianferrada.sistemabecas.repository.PostulacionRepository;

@Controller
@RequestMapping("/api/postulacion")
public class PostulacionController {
	@Autowired
	private PostulacionRepository postulacionRepository;
	
	@Autowired
	private BecaRepository becaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@PostMapping("/crear")
	public @ResponseBody Postulacion crearPostulacion(@RequestBody PostulacionDto postulacionDto) {
		Postulacion postulacion = new Postulacion();
		Beca beca = becaRepository.findById(postulacionDto.getIdBeca()).orElse(null);
		Estudiante estudiante = estudianteRepository.findById(postulacionDto.getIdEstudiante()).orElse(null);
		
		postulacion.setEstado(postulacionDto.getEstado());
		postulacion.setComentario(postulacionDto.getComentario());
		postulacion.setBeca(beca);
		postulacion.setEstudiante(estudiante);
		
		return postulacionRepository.save(postulacion);
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody Postulacion obtenerPostulacion(@PathVariable int id) {
		return postulacionRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/listar")
	public @ResponseBody Iterable<Postulacion> listarPostulaciones() {
		return postulacionRepository.findAll();
	}
	
	@PutMapping("/editar/{id}")
	public @ResponseBody Postulacion editarPostulacion(
		@PathVariable int id, @RequestBody PostulacionDto postulacionDto
	) {
		Postulacion postulacion = postulacionRepository.findById(id).orElse(null);
		
		postulacion.setEstado(postulacionDto.getEstado());
		postulacion.setComentario(postulacionDto.getComentario());
		
		return postulacionRepository.save(postulacion);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody StandardResponse eliminarPostulacion(@PathVariable int id) {
		postulacionRepository.deleteById(id);
		
		return new StandardResponse(true);
	}
}