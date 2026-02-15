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

import io.github.fabianferrada.sistemabecas.dto.DocumentosDto;
import io.github.fabianferrada.sistemabecas.dto.StandardResponse;
import io.github.fabianferrada.sistemabecas.model.Documentos;
import io.github.fabianferrada.sistemabecas.repository.BecaRepository;
import io.github.fabianferrada.sistemabecas.repository.DocumentosRepository;

@Controller
@RequestMapping("/api/documentos")
public class DocumentosController {
	@Autowired
	private DocumentosRepository documentosRepository;
	
	@Autowired
	private BecaRepository becaRepository;
	
	@PostMapping("/crear")
	public @ResponseBody Documentos crearDocumento(@RequestBody DocumentosDto documentoDto) {
		Documentos documento = new Documentos();
		
		documento.setNombre(documentoDto.getNombre());
		documento.setDescripcion(documentoDto.getDescripcion());
		documento.setBeca(becaRepository.findById(documentoDto.getIdBeca()).orElse(null));
		
		return documentosRepository.save(documento);
	}
	
	@GetMapping("/listar/{idBeca}")
	public @ResponseBody Iterable<Documentos> listarDocumentos(@PathVariable int idBeca) {
		return documentosRepository.findByBecaId(idBeca);
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody Documentos obtenerDocumento(@PathVariable int id) {
		return documentosRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/editar/{id}")
	public @ResponseBody Documentos editarDocumento(
		@PathVariable int id, @RequestBody DocumentosDto documentoDto
	) {
		Documentos documento = documentosRepository.findById(id).orElse(null);
		
		documento.setNombre(documentoDto.getNombre());
		documento.setDescripcion(documentoDto.getDescripcion());
		
		return documentosRepository.save(documento);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody StandardResponse eliminarDocumento(@PathVariable int id) {
		documentosRepository.deleteById(id);
		
		return new StandardResponse(true);
	}
}