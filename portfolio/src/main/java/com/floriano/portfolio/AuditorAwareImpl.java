package com.floriano.portfolio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.floriano.portfolio.repository.UsuarioRepository;
import com.floriano.portfolio.entity.Usuario;
import com.floriano.portfolio.service.UsuarioService;



@Component
public class AuditorAwareImpl implements AuditorAware<Usuario> {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public Optional<Usuario> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return Optional.ofNullable(new Usuario(1L));
		} else {
			System.out.println("Auditando" + authentication.getName());
			/*System.out.println(usuarioService.getIdUserSession());*/

			return Optional.ofNullable(new Usuario(2L));
		}
	}

}
