package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>, JpaSpecificationExecutor<Rol> {

	List<Rol> findByActivoTrue();

	Rol findByActivoTrueAndId(Long id);
}
