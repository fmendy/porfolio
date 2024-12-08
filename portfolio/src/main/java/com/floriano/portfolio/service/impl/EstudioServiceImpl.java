package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.repository.EstudioRepository;
import com.floriano.portfolio.dto.publico.PublicoEstudioForm;
import com.floriano.portfolio.model.Estudio;
import com.floriano.portfolio.service.EstudioService;
import com.floriano.portfolio.util.EstudioUtil;

@Service
public class EstudioServiceImpl implements EstudioService {

	@Autowired
	private EstudioRepository estudioRepository;

	@Override
	public List<Estudio> getAllActivos() {
		return estudioRepository.findByActivoTrue();
	}

	@Override
	public List<PublicoEstudioForm> getAllActivosPublic() {
		return EstudioUtil.listEstudioToListPublicEstudioForm(getAllActivos());
	}

}
