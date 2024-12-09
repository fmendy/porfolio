package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.repository.CertificacionRepository;
import com.floriano.portfolio.dto.publico.PublicoCertificacionForm;
import com.floriano.portfolio.model.Certificacion;
import com.floriano.portfolio.service.CertificacionService;
import com.floriano.portfolio.util.CertificacionUtil;

@Service
public class CertificacionServiceImpl implements CertificacionService {

	@Autowired
	private CertificacionRepository certificacionRepository;

	@Override
	public List<Certificacion> getAllActivos() {

		return certificacionRepository.findByActivoTrue();
	}

	@Override
	public List<PublicoCertificacionForm> getAllActivosPublic() {
		return CertificacionUtil.listCertificacionToListPublicCertificacionForm(getAllActivos());
	}
	
	
}
