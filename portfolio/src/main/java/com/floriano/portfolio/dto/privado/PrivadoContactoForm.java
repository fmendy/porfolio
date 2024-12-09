package com.floriano.portfolio.dto.privado;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PrivadoContactoForm implements Serializable {

	private static final long serialVersionUID = 4279591279294991683L;
	
	private Long id;

	private String mail;

	private String titulo;

	private String asunto;
	
	private boolean leido;
	
	private boolean respondido;
	
	private Date fecha;
}
