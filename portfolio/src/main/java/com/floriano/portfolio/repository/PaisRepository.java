package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {

	List<Pais> findByActivoTrue();
}
