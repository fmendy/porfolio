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
@Table(name = "trabajo_tarea")
public class TrabajoTarea extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6618995880978083347L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_trabajo")
	private Trabajo trabajo;
}
