package io.github.fabianferrada.sistemabecas_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {
	private UserDetailsService userDetailsService;
	
	public ProjectConfig(UsuarioBecasDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		http
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(
			c -> c.anyRequest().permitAll()
		)
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
}
