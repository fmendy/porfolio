package com.floriano.portfolio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.entity.Certificacion;

@Repository
public interface CertificacionRepository extends CrudRepository<Certificacion, Long> {

	List<Certificacion> findByActivoTrue();
}