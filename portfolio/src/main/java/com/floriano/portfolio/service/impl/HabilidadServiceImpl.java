package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.model.Habilidad;
import com.floriano.portfolio.repository.HabilidadRepository;
import com.floriano.portfolio.service.HabilidadService;

@Service
public class HabilidadServiceImpl implements HabilidadService {

	@Autowired
	private HabilidadRepository habilidadRepository;

	@Override
	public List<Habilidad> getAllActivos() {
		return habilidadRepository.findByActivoTrue();
	}
}
