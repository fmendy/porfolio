package com.floriano.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.floriano.portfolio.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	List<Usuario> findByActivoTrue();

	Usuario findByActivoTrueAndId(Long id);

	Usuario findByActivoTrueAndNombreEqualsIgnoreCase(String nombre);
	
	@Query("SELECT u.rol.nombre FROM Usuario u where u.nombre = :nombre")
	String getRolNombreByActivoTrueAndNombreEqualsIgnoreCase(@Param("nombre") String nombre);
}
