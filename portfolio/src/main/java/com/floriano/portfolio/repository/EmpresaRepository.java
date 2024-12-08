package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

	List<Empresa> findByActivoTrue();
}
