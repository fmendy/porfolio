package com.floriano.portfolio.service;

import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoEstudioForm;
import com.floriano.portfolio.model.Estudio;

public interface EstudioService {

	List<Estudio> getAllActivos();

	List<PublicoEstudioForm> getAllActivosPublic();
}
