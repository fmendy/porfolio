package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.repository.CursoRepository;
import com.floriano.portfolio.entity.Curso;
import com.floriano.portfolio.model.publico.PublicCursoForm;
import com.floriano.portfolio.service.CursoService;
import com.floriano.portfolio.util.PublicCursoMapper;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> getAllActivos() {
		return cursoRepository.findByActivoTrue();
	}

	@Override
	public List<PublicCursoForm> getAllActivosPublic() {
		return PublicCursoMapper.listCursoToListPublicCursoForm(cursoRepository.findByActivoTrue());
	}
}
