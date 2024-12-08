package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.model.InstitucionEductativa;

@Repository
public interface InstitucionEducativaRepository extends CrudRepository<InstitucionEductativa, Long> {

	List<InstitucionEductativa> findByActivoTrue();
}
