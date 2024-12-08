package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	List<Usuario> findByActivoTrue();

	Usuario findByActivoTrueAndId(Long id);

	Usuario findByActivoTrueAndNombreEqualsIgnoreCase(String nombre);
}
