package com.floriano.portfolio.dto.specifications;

import java.util.ArrayList;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.floriano.portfolio.dto.filter.ContactoFilter;
import com.floriano.portfolio.model.Contacto;
import com.floriano.portfolio.util.Utils;

import jakarta.persistence.criteria.Predicate;

public class ContactoSpecifications {

	public static Specification<Contacto> filter(ContactoFilter filter) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			predicates.add(criteriaBuilder.equal(root.get("activo"), true));

			if (StringUtils.hasText(filter.getMail())) {
				Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("mail")),
						"%" + filter.getMail().toUpperCase() + "%");
				predicates.add(predicate);
			}

			if (StringUtils.hasText(filter.getAsunto())) {
				Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("asunto")),
						"%" + filter.getAsunto().toUpperCase() + "%");
				predicates.add(predicate);
			}

			if (filter.getLeido() != null) {
				Predicate predicate = criteriaBuilder.equal(root.get("leido"), filter.getLeido());
				predicates.add(predicate);
			}

			if (filter.getRespondido() != null) {
				Predicate predicate = criteriaBuilder.equal(root.get("respondido"), filter.getRespondido());
				predicates.add(predicate);
			}

			if (filter.getFechaDesde() != null) {

				Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("fechaCreacion"),
						Utils.dateSetHoraMinutoSegundoMilisegundo(filter.getFechaDesde(), 0, 0, 0, 0));
				predicates.add(predicate);
			}

			if (filter.getFechaHasta() != null) {
				Predicate predicate = criteriaBuilder.lessThanOrEqualTo(root.get("fechaCreacion"),
						Utils.dateSetHoraMinutoSegundoMilisegundo(filter.getFechaHasta(), 23, 59, 59, 59));
				predicates.add(predicate);
			}
			return criteriaBuilder.and(predicates.toArray((new Predicate[0])));
		};
	}
}
