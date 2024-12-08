package com.floriano.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.dto.RolForm;
import com.floriano.portfolio.repository.RolRepository;
import com.floriano.portfolio.service.RolService;
import com.floriano.portfolio.util.RolUtility;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<RolForm> getListForm() {
		return RolUtility.listRolToListForm(rolRepository.findByActivoTrue());
	}

}
