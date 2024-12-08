package com.floriano.portfolio.service;

import java.util.List;

import com.floriano.portfolio.entity.Curso;
import com.floriano.portfolio.model.publico.PublicCursoForm;

public interface CursoService {

	List<Curso> getAllActivos();
	
	List<PublicCursoForm> getAllActivosPublic();
}
