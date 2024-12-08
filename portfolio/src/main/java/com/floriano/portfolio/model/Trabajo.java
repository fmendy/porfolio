package com.floriano.portfolio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Filter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "trabajo")
public class Trabajo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4719230377550866075L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	@Column(name = "fecha_inicio", nullable = false)
	private Date fechaInicio;

	@Column(name = "fecha_fin")
	private Date fechaFin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais", nullable = false)
	private Pais pais;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comunidad_autonoma", nullable = false)
	private ComunidadAutonoma comunidadAutonoma;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia", nullable = false)
	private Provincia provincia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_municipio", nullable = false)
	private Municipio municipio;

	@Column(name = "otra_ubicacion", length = 255)
	private String otraUbicacion;

	@Column(name = "observaciones", length = 2555)
	private String observaciones;

	@OneToMany(mappedBy = "trabajo", fetch = FetchType.LAZY)
	@Filter(name = "activo", condition = "activo = true")
	private List<TrabajoHabilidad> listTrabajoHabilidad;

	@OneToMany(mappedBy = "trabajo", fetch = FetchType.LAZY)
	@Filter(name = "activo", condition = "activo = true")
	private List<TrabajoTarea> listTrabajoTarea;

}
