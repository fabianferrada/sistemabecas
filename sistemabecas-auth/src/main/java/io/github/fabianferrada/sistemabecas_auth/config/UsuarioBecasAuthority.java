package io.github.fabianferrada.sistemabecas_auth.config;

import org.springframework.security.core.GrantedAuthority;

public class UsuarioBecasAuthority implements GrantedAuthority {
	private String authority;
	
	public UsuarioBecasAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		return this.authority;
	}
}