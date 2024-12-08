package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.Estudio;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Long> {

	List<Estudio> findByActivoTrue();
}
