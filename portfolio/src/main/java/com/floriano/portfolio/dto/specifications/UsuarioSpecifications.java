package com.floriano.portfolio.dto.specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.floriano.portfolio.filter.UsuarioFilter;
import com.floriano.portfolio.model.Usuario;

import jakarta.persistence.criteria.Predicate;

public class UsuarioSpecifications {

	public static Specification<Usuario> filter(UsuarioFilter filter) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			predicates.add(criteriaBuilder.equal(root.get("activo"), true));

			if (StringUtils.hasText(filter.getNombre())) {
				Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("nombre")),
						"%" + filter.getNombre().toUpperCase() + "%");
				predicates.add(predicate);
			}

			if (filter.getRolId() != null) {
				Predicate predicate = criteriaBuilder.equal(root.get("rol").get("id"), filter.getRolId());
				predicates.add(predicate);
			}
			return criteriaBuilder.and(predicates.toArray((new Predicate[0])));
		};
	}
}
