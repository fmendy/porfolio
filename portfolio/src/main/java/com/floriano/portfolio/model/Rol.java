package com.floriano.portfolio.model;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

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
@Table(name = "rol")
@Transactional
public class Rol extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8041114605497878252L;

	public Rol(Long id) {
		super();
		this.id = id;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, unique = true, nullable = false)
	private String nombre;
}
