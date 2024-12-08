package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.repository.TrabajoRepository;
import com.floriano.portfolio.dto.publico.PublicoTrabajoForm;
import com.floriano.portfolio.model.Trabajo;
import com.floriano.portfolio.service.TrabajoService;
import com.floriano.portfolio.util.TrabajoUtil;

@Service
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private TrabajoRepository trabajoRepository;

	@Override
	public List<Trabajo> getAllActivos() {
		return trabajoRepository.findByActivoTrue();
	}

	@Override
	public List<PublicoTrabajoForm> getPublicTrabajos() {
		return TrabajoUtil
				.listTrabajoToListPublicTrabajoForm(trabajoRepository.findByActivoTrueOrderByFechaInicioDesc());
	}

}
