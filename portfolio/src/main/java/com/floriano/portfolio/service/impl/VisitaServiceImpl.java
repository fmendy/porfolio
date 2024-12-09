package com.floriano.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.model.Visita;
import com.floriano.portfolio.repository.VisitaRepository;
import com.floriano.portfolio.service.VisitaService;

@Service
public class VisitaServiceImpl implements VisitaService {

	@Autowired
	private VisitaRepository visitaRepository;

	@Override
	public void guardarVisita(String url, String ip, String agente) {

		if (!url.contains("/js/") && !url.contains("/css/") && !url.contains("/img/")) {
			Visita visita = new Visita();
			visita.setIp(ip);
			visita.setUrl(url);
			visita.setAgente(agente);
			visitaRepository.save(visita);
		}

	}

}
