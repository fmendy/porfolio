package com.floriano.portfolio.dto.publico;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicoCursoForm implements Serializable {

	private static final long serialVersionUID = -7160704212917143138L;

	private String nombre;

	private Long duracion;

	private Date fecha;

	private String institucionEductativaNombre;

	private String institucionEductativaWeb;

}
