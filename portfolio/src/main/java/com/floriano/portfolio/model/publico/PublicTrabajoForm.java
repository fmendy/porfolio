package com.floriano.portfolio.model.publico;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicTrabajoForm implements Serializable {

	private static final long serialVersionUID = -8212571383196454159L;
	
	private String nombre;
	
	private String empresaNombre;
	
	private String fechaInicio;
	
	private String fechaFin;
	
	private String anosTrabajo;
	
	private String duracionTrabajo;
	
	private String lugarDeTrabajo;
	
	private String observaciones;
	
	private List<PublicHabilidadForm> listHabilidad;
	
	private List<PublicTrabajoTareaForm> listTrabajoTarea;

}
