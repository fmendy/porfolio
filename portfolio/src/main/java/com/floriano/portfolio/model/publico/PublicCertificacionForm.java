package com.floriano.portfolio.model.publico;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicCertificacionForm implements Serializable {

	private static final long serialVersionUID = 6290447244785654335L;

	private String nombre;

	private String certificateNumber;

	private String url;

	private String imagen;

}
