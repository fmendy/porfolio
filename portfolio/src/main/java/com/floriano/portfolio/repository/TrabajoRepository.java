package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.model.Trabajo;

@Repository
public interface TrabajoRepository extends CrudRepository<Trabajo, Long> {

	List<Trabajo> findByActivoTrue();

	List<Trabajo> findByActivoTrueOrderByFechaInicioDesc();
}
