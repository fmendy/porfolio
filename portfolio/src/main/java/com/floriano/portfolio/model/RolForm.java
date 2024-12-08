package com.floriano.portfolio.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RolForm implements Serializable {

	private static final long serialVersionUID = 45376592557141549L;

	private Long id;

	@NotBlank(message = "{rol.form.requerido.nombre}")
	private String nombre;

}
