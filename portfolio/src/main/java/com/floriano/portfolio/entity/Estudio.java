package com.floriano.portfolio.entity;

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
@Table(name = "estudio")
public class Estudio extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8834850571529037504L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Column(name = "nivel_eqf_mec")
	private Long nivelEqfMec;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_institucion_educativa")
	private InstitucionEductativa institucionEductativa;

	@OneToMany(mappedBy = "estudio", fetch = FetchType.LAZY)
	@Filter(name = "activo", condition = "activo = true")
	private List<EstudioObservacion> listEstudioObservacion;

}
