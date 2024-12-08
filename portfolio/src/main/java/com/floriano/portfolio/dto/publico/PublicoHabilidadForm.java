package com.floriano.portfolio.dto.publico;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicoHabilidadForm implements Serializable {

	private static final long serialVersionUID = 7841087060357322246L;
	
	private String nombre;
}
