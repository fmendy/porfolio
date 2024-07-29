package com.floriano.portfolio.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5526430364598206935L;

	@Column(name = "activo")
	private boolean activo;

	@CreationTimestamp
	@Column(name = "fecha_creacion", updatable = false)
	private Date fechaCreacion;

	@UpdateTimestamp
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

}
