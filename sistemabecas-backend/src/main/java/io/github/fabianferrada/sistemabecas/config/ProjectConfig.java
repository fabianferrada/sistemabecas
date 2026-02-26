package io.github.fabianferrada.sistemabecas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class ProjectConfig {
	@Value("${tokens.jwt-token}")
	private String keystr;
	
	public ProjectConfig() {}
	
	@Bean
	NimbusJwtDecoder jwtDecoder() {
		byte key[] = keystr.getBytes();
		SecretKeySpec secretKey = new SecretKeySpec(key, "HmacSHA256");
		
		return NimbusJwtDecoder.withSecretKey(secretKey).build();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
			c -> c.requestMatchers(
				"/api/apelacion/**",
				"/api/beca/**",
				"/api/docpostulacion/**",
				"/api/documentos/**",
				"/api/estudiante/**",
				"/api/postulacion/**"
			).hasAuthority("SCOPE_estudiante")
			.requestMatchers("/api/administrador/**").hasAuthority("SCOPE_administrador")
		)
			.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
		
		return http.build();
	}
}