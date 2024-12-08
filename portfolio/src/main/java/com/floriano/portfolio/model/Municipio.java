package com.floriano.portfolio.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "municipio")
public class Municipio extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4480595478530312236L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@Column(name = "codigo_ine", nullable = false)
	private Long codigoIne;

	@Column(name = "dc", nullable = false)
	private Long dc;
}
