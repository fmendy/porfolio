package com.floriano.portfolio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.floriano.portfolio.util.Constantes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSessionForm implements Serializable, UserDetails {

	private static final long serialVersionUID = 6505456348418589715L;

	private String username;

	private String password;

	private String role;

	private Long id;

	public UserSessionForm(com.floriano.portfolio.entity.Usuario usuario) {
		this.username = usuario.getNombre();
		this.password = usuario.getPassword();
		this.role = usuario.getRol().getNombre();
		this.id = usuario.getId();
	}

	public UserSessionForm(String nombre, String password, String role, Long id) {
		this.username = nombre;
		this.password = password;
		this.role = role;
		this.id = id;
	}

	// -----------------SECURITY INFO

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(Constantes.ROLE + Constantes.GUION_BAJO + role));
		return authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
