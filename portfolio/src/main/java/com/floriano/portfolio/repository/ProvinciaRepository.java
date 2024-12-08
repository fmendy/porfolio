package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.model.Provincia;

@Repository
public interface ProvinciaRepository extends CrudRepository<Provincia, Long> {

	List<Provincia> findByActivoTrue();
}
