package com.floriano.portfolio.model.publico;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicHabilidadForm implements Serializable {

	private static final long serialVersionUID = 7841087060357322246L;
	
	private String nombre;
}
