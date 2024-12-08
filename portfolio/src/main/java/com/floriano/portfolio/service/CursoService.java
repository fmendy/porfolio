package com.floriano.portfolio.service;

import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoCursoForm;
import com.floriano.portfolio.model.Curso;

public interface CursoService {

	List<Curso> getAllActivos();
	
	List<PublicoCursoForm> getAllActivosPublic();
}
