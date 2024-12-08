package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.repository.EmpresaRepository;
import com.floriano.portfolio.entity.Empresa;
import com.floriano.portfolio.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public List<Empresa> getAllActivos() {
		return empresaRepository.findByActivoTrue();
	}

}
