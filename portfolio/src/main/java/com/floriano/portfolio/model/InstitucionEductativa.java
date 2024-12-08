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
@Table(name = "institucion_educativa")
public class InstitucionEductativa extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2411060496825945252L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "url", length = 255)
	private String url;

}
