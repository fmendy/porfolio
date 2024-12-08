package com.floriano.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.repository.VisitaRepository;
import com.floriano.portfolio.service.VisitaService;

@Service
public class VisitaServiceImpl implements VisitaService {

	@Autowired
	private VisitaRepository visitaRepository;

	@Override
	public void guardarVisita(String url, String ip) {
		/*
		 * Visita visita = new Visita(); visita.setIp(ip); visita.setUrl(url);
		 * visita.setActivo(true); visitaRepository.save(visita);
		 */
	}

}
