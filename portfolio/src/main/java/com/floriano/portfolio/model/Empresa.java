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
@Table(name = "empresa")
public class Empresa extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -6397613823811959011L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@Column(name = "logo", length = 255)
	private String logo;

	@Column(name = "web", length = 255)
	private String web;

}
