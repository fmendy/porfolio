package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.Visita;

@Repository
public interface VisitaRepository  extends CrudRepository<Visita, Long>{

	List<Visita> findByActivoTrue();
}
