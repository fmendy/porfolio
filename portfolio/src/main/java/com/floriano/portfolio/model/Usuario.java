package com.floriano.portfolio.model;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

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
@Table(name = "usuario")
@Transactional
public class Usuario extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 3656431595003998229L;

	public Usuario(Long id) {
		super();
		this.id = id;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, unique = true, nullable = false)
	private String nombre;

	@Column(name = "email", length = 255, unique = true, nullable = false)
	private String email;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol")
	private Rol rol;

}
