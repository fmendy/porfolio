package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.repository.TrabajoRepository;
import com.floriano.portfolio.entity.Trabajo;
import com.floriano.portfolio.model.publico.PublicTrabajoForm;
import com.floriano.portfolio.service.TrabajoService;
import com.floriano.portfolio.util.PublicTrabajoMapper;

@Service
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private TrabajoRepository trabajoRepository;

	@Override
	public List<Trabajo> getAllActivos() {
		return trabajoRepository.findByActivoTrue();
	}

	@Override
	public List<PublicTrabajoForm> getPublicTrabajos() {
		return PublicTrabajoMapper
				.listTrabajoToListPublicTrabajoForm(trabajoRepository.findByActivoTrueOrderByFechaInicioDesc());
	}

}
