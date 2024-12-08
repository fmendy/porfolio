package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.Habilidad;

@Repository
public interface HabilidadRepository extends CrudRepository<Habilidad, Long> {

	List<Habilidad> findByActivoTrue();
}
