package com.floriano.portfolio.dto.publico;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicoEstudioObservacionForm implements Serializable {

	private static final long serialVersionUID = 95538776228293208L;

	private String nombre;

	private String observacion;
}
