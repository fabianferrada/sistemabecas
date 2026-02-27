package io.github.fabianferrada.sistemabecas_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import io.github.fabianferrada.sistemabecas_auth.dto.LoginDto;
import io.github.fabianferrada.sistemabecas_auth.dto.StandardResponse;
import io.github.fabianferrada.sistemabecas_auth.model.Estudiante;
import io.github.fabianferrada.sistemabecas_auth.repository.EstudianteRepository;

@Controller
@RequestMapping("/api/estudiante")
public class EstudianteController {
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	private AuthenticationManager authManager;
	
	public EstudianteController(AuthenticationManager authManager) {
		this.authManager = authManager;
	}
	
	@PostMapping("/login")
	public @ResponseBody StandardResponse login(@RequestBody LoginDto loginDto) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
			loginDto.email,
			loginDto.password
		);
		try {
			authManager.authenticate(token);
		} catch (AuthenticationException e) {
			return new StandardResponse(false);
		}
		
		return new StandardResponse(true);
	}
	
	@PostMapping("/registrar")
	public @ResponseBody StandardResponse crearEstudiante(@RequestBody Estudiante estudiante) {
		estudianteRepository.save(estudiante);
		
		return new StandardResponse(true);
	}
}
