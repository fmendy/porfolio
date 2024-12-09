package com.floriano.portfolio.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name = "visita")
public class Visita implements Serializable {

	private static final long serialVersionUID = -7080406867358141926L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "url", length = 255, nullable = false)
	private String url;

	@Column(name = "agente", length = 455, nullable = false)
	private String agente;

	@Column(name = "ip", length = 255, nullable = false)
	private String ip;

	@Column(name = "Activo", insertable = false)
	@ColumnDefault("1")
	private boolean activo;

	@CreatedDate
	@Column(name = "fecha_creacion", insertable = false, nullable = false, updatable = false)
	private Date fechaCreacion;

	@LastModifiedDate
	@Column(name = "fecha_modificacion", insertable = false, nullable = false)
	private Date fechaModificacion;

}
