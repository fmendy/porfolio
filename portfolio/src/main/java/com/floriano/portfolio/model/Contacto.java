package com.floriano.portfolio.model;

import java.io.Serializable;

import org.hibernate.annotations.ColumnDefault;

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
@Table(name = "contacto")
public class Contacto extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5867880798087480223L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "mail", length = 255, nullable = false)
	private String mail;

	@Column(name = "titulo", length = 255, nullable = false)
	private String titulo;

	@Column(name = "asunto", length = 2400, nullable = false)
	private String asunto;

	@Column(name = "leido", insertable = false)
	@ColumnDefault("0")
	private boolean leido;
	
	@Column(name = "respondido", insertable = false)
	@ColumnDefault("0")
	private boolean respondido;
}
