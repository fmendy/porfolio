package com.floriano.portfolio.service;

import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoCertificacionForm;
import com.floriano.portfolio.model.Certificacion;

public interface CertificacionService {

	List<Certificacion> getAllActivos();
	
	List<PublicoCertificacionForm> getAllActivosPublic();
}
