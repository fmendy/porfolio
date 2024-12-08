package com.floriano.portfolio.service;

import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoTrabajoForm;
import com.floriano.portfolio.model.Trabajo;

public interface TrabajoService {

	List<Trabajo> getAllActivos();

	List<PublicoTrabajoForm> getPublicTrabajos();
}
