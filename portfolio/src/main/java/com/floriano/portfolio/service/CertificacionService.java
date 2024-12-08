package com.floriano.portfolio.service;

import java.util.List;

import com.floriano.portfolio.entity.Certificacion;
import com.floriano.portfolio.model.publico.PublicCertificacionForm;

public interface CertificacionService {

	List<Certificacion> getAllActivos();
	
	List<PublicCertificacionForm> getAllActivosPublic();
}
