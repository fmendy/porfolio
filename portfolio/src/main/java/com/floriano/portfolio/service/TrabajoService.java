package com.floriano.portfolio.service;

import java.util.List;

import com.floriano.portfolio.entity.Trabajo;
import com.floriano.portfolio.model.publico.PublicTrabajoForm;

public interface TrabajoService {

	List<Trabajo> getAllActivos();

	List<PublicTrabajoForm> getPublicTrabajos();
}