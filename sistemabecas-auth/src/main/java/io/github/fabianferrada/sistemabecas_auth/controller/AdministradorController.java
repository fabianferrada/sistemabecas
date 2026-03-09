package io.github.fabianferrada.sistemabecas_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.spec.SecretKeySpec;

import io.github.fabianferrada.sistemabecas_auth.dto.LoginDto;
import io.github.fabianferrada.sistemabecas_auth.repository.AdministradorRepository;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	@Autowired
	private AdministradorRepository administradorRepository;
	
	private NimbusJwtEncoder jwtEncoder;
	
	private AuthenticationManager authManager;
	
	public AdministradorController(
		AuthenticationManager authManager,
		@Value("${tokens.jwt-token}") String jwtToken
	) {
		this.authManager = authManager;
		
		SecretKeySpec secretKey = new SecretKeySpec(
			jwtToken.getBytes(),
			"Hmac256"
		);
		
		jwtEncoder = NimbusJwtEncoder.withSecretKey(
			secretKey
		).build();
	}
	
	@PostMapping("/login")
	public @ResponseBody String login(@RequestBody LoginDto loginDto) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
			loginDto.email,
			loginDto.password
		);
		
		try {
			authManager.authenticate(token);
		} catch (AuthenticationException e) {
			return null;
		}
		
		return jwtEncoder.encode(
			JwtEncoderParameters.from(
				JwtClaimsSet.builder()
				.claim("scope", "administrador")
				.build()
			)
		).getTokenValue();
	}
}
