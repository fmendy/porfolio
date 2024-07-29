package com.floriano.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.dao.UsuarioRepository;
import com.floriano.portfolio.entity.Usuario;
import com.floriano.portfolio.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario getById(Long id) {
		return usuarioRepository.findByActivoTrueAndId(id);
	}

}
