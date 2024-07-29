package com.floriano.portfolio.form.publico;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicEstudioForm implements Serializable {

	private static final long serialVersionUID = 1105040497784380512L;

	private String nombre;

	private String institucionEducativaNombre;

	private String institucionEducativaUrl;

	private String fechaInicio;
	
	private String anoInicio;

	private String fechaFin;
	
	private String anoFin;

	private Long nivelEqfMec;

	private List<PublicEstudioObservacionForm> listEstudioObservacion;

}
