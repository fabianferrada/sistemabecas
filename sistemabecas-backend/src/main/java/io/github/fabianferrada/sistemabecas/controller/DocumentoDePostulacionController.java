package io.github.fabianferrada.sistemabecas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import io.github.fabianferrada.sistemabecas.dto.DocumentosDePostulacionDto;
import io.github.fabianferrada.sistemabecas.dto.StandardResponse;
import io.github.fabianferrada.sistemabecas.model.DocumentoDePostulacion;
import io.github.fabianferrada.sistemabecas.repository.DocumentoDePostulacionRepository;
import io.github.fabianferrada.sistemabecas.repository.PostulacionRepository;
import io.github.fabianferrada.sistemabecas.repository.DocumentosRepository;
import io.github.fabianferrada.sistemabecas.service.ArchivosService;

@Controller
@RequestMapping("/api/docpostulacion")
public class DocumentoDePostulacionController {
	@Autowired
	private DocumentoDePostulacionRepository documentoDePostulacionRepository;
	
	@Autowired
	private PostulacionRepository postulacionRepository;
	
	@Autowired
	private DocumentosRepository documentosRepository;
	
	@Autowired
	private ArchivosService archivosService;
	
	@PostMapping("/crear/{idPostulacion}/{idDocumento}")
	public @ResponseBody DocumentoDePostulacion crearDocumentoPostulacion(
		@RequestParam("file") MultipartFile file,
		@PathVariable int idPostulacion,
		@PathVariable int idDocumento
	) {
		DocumentoDePostulacion documento = new DocumentoDePostulacion();
		
		String path = archivosService.saveFile(file);
		
		documento.setUrl(path);
		documento.setPostulacion(
			postulacionRepository.findById(idPostulacion).orElse(null)
		);
		documento.setDocumento(
			documentosRepository.findById(idDocumento).orElse(null)
		);
		
		return documentoDePostulacionRepository.save(documento);
	}
	
	@GetMapping("obtenerSimple/{id}")
	public @ResponseBody DocumentoDePostulacion obtenerDocumentoPostulacionSimple(
		@PathVariable int id
	) {
		return documentoDePostulacionRepository.findById(id).orElse(null);
	}
	
	@GetMapping("obtenerArchivo/{id}")
	public @ResponseBody ResponseEntity<Resource> obtenerDocumentoPostulacionArchivo(
		@PathVariable int id
	) {
		DocumentoDePostulacion documento = documentoDePostulacionRepository.findById(id)
			.orElse(null);
		
		String filename = documento.getDocumento().getNombre() + ".pdf";
		
		Resource archivo = archivosService.getFile(documento.getUrl());
		
		return ResponseEntity.ok()
			.contentType(MediaType.APPLICATION_OCTET_STREAM)
			.header(
				HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + filename + "\""
			)
			.body(archivo);
	}
	
	@PutMapping("editar/{id}")
	public @ResponseBody DocumentoDePostulacion editarDocumentoPostulacion(
		@RequestParam("file") MultipartFile file,
		@PathVariable int id
	) {
		DocumentoDePostulacion documento = documentoDePostulacionRepository.findById(id)
			.orElse(null);

		archivosService.deleteFile(documento.getUrl());
		
		String path = archivosService.saveFile(file);
		
		documento.setUrl(path);
		
		return documentoDePostulacionRepository.save(documento);
	}
	
	@DeleteMapping("eliminar/{id}")
	public @ResponseBody StandardResponse eliminarDocumentoPostulacion(@PathVariable int id) {
		DocumentoDePostulacion doc = documentoDePostulacionRepository.findById(id).orElse(null);
		
		if (doc == null) {
			return new StandardResponse(true);
		}
		
		archivosService.deleteFile(doc.getUrl());
		
		documentoDePostulacionRepository.deleteById(id);
		return new StandardResponse(true);
	}
}