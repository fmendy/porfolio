package com.floriano.portfolio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.InstitucionEductativa;

@Repository
public interface InstitucionEducativaRepository extends CrudRepository<InstitucionEductativa, Long> {

	List<InstitucionEductativa> findByActivoTrue();
}
