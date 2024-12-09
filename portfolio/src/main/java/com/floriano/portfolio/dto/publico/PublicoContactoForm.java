package com.floriano.portfolio.dto.publico;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicoContactoForm implements Serializable {

	private static final long serialVersionUID = 8331046427907770981L;

	@NotBlank
	@Size(max = 250)
	private String mail;

	@NotBlank
	@Size(max = 250)
	private String titulo;

	@NotBlank
	@Size(max = 2500)
	private String asunto;
	
	private boolean politicaPrivacidad;

}
