package io.github.fabianferrada.sistemabecas_auth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.github.fabianferrada.sistemabecas_auth.model.Administrador;
import io.github.fabianferrada.sistemabecas_auth.model.Estudiante;
import io.github.fabianferrada.sistemabecas_auth.repository.EstudianteRepository;
import io.github.fabianferrada.sistemabecas_auth.repository.AdministradorRepository;

@Component
public class UsuarioBecasDetailsService implements UserDetailsService {
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	public UsuarioBecasDetailsService() {}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		UsuarioBecasDetails userDetails;
		
		// Primero testeamos si se trata de un estudiante
		List<Estudiante> estudiante = estudianteRepository.findByEmail(username);
		
		if (!estudiante.isEmpty()) {
			userDetails = new UsuarioBecasDetails(
				estudiante.get(0).getEmail(),
				estudiante.get(0).getContrasena(),
				"estudiante"
			);
			
			return userDetails;
		}
		
		List<Administrador> administrador = administradorRepository.findByEmail(username);
		
		if (administrador.isEmpty()) {
			throw new UsernameNotFoundException("username not found");
		}
		
		userDetails = new UsuarioBecasDetails(
			administrador.get(0).getEmail(),
			administrador.get(0).getContrasena(),
			"administrador"
		);
		
		return userDetails;
	}
}
