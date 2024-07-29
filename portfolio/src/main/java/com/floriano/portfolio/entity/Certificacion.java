package com.floriano.portfolio.entity;

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
@Table(name = "certificacion")
public class Certificacion extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8214671352448599231L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@Column(name = "certificate_number", length = 255)
	private String certificateNumber;

	@Column(name = "url", length = 255)
	private String url;

	@Column(name = "imagen", length = 255)
	private String imagen;

}
