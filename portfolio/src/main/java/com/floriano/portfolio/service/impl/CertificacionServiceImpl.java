package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.dao.CertificacionRepository;
import com.floriano.portfolio.entity.Certificacion;
import com.floriano.portfolio.form.publico.PublicCertificacionForm;
import com.floriano.portfolio.service.CertificacionService;
import com.floriano.portfolio.util.PublicCertificacionMapper;

@Service
public class CertificacionServiceImpl implements CertificacionService {

	@Autowired
	private CertificacionRepository certificacionRepository;

	@Override
	public List<Certificacion> getAllActivos() {

		return certificacionRepository.findByActivoTrue();
	}

	@Override
	public List<PublicCertificacionForm> getAllActivosPublic() {
		return PublicCertificacionMapper.listCertificacionToListPublicCertificacionForm(getAllActivos());
	}
	
	
}
