package com.floriano.portfolio.service;

import java.util.List;

import com.floriano.portfolio.entity.Estudio;
import com.floriano.portfolio.model.publico.PublicEstudioForm;

public interface EstudioService {

	List<Estudio> getAllActivos();

	List<PublicEstudioForm> getAllActivosPublic();
}
