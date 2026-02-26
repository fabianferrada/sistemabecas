package io.github.fabianferrada.sistemabecas_auth.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioBecasDetails implements UserDetails {
	private String username;
	private String password;
	private String role;
	
	public UsuarioBecasDetails(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	@Override
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = Arrays.asList();
		
		authorities.add(new UsuarioBecasAuthority(role));
		
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public String getUsername() {
		return this.username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}