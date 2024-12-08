package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.Municipio;

@Repository
public interface MunicipioRepository extends CrudRepository<Municipio, Long> {

	List<Municipio> findByActivoTrue();
}
