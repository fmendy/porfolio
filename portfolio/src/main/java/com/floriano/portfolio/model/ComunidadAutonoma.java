package com.floriano.portfolio.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comunidad_autonoma")
public class ComunidadAutonoma extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 3379456859352720719L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@Column(name = "codigo_ine", nullable = false)
	private Long codigoIne;

}
