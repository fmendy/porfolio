package com.floriano.portfolio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

	List<Empresa> findByActivoTrue();
}
