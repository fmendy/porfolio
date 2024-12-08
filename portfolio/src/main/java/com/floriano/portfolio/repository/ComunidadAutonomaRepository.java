package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.ComunidadAutonoma;

@Repository
public interface ComunidadAutonomaRepository extends CrudRepository<ComunidadAutonoma, Long> {

	List<ComunidadAutonoma> findByActivoTrue();
}
