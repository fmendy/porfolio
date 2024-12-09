package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>, JpaSpecificationExecutor<Contacto> {

	List<Contacto> findByActivoTrue();

	List<Contacto> findByActivoTrueAndLeidoFalse();
}
