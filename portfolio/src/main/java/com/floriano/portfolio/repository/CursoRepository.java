package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

	List<Curso> findByActivoTrue();
}
