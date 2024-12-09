package com.floriano.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.repository.UsuarioRepository;
import com.floriano.portfolio.dto.UserSessionForm;
import com.floriano.portfolio.model.Usuario;
import com.floriano.portfolio.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario getById(Long id) {
		return usuarioRepository.findByActivoTrueAndId(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByActivoTrueAndNombreEqualsIgnoreCase(username);
		if (usuario != null) {
			String role = usuarioRepository.getRolNombreByActivoTrueAndNombreEqualsIgnoreCase(username);

			UserSessionForm retVal = new UserSessionForm(username, usuario.getPassword(), role, usuario.getId());
			return retVal;
		}
		return null;
	}

}
