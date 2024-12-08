package com.floriano.portfolio.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5526430364598206935L;

	@Column(name = "Activo", insertable = false)
	@ColumnDefault("1")
	private boolean activo;

	@CreatedDate
	@Column(name = "fecha_creacion", insertable = false, nullable = false, updatable = false)
	private Date fechaCreacion;

	@LastModifiedDate
	@Column(name = "fecha_modificacion", insertable = false, nullable = false)
	private Date fechaModificacion;

	@CreatedBy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_creacion", nullable = false, updatable = false)
	private Usuario usuarioCreacion;

	@LastModifiedBy
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_usuario_modificacion")
	private Usuario usuarioModificacion;

}
