package com.floriano.portfolio.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginForm implements Serializable {

	private static final long serialVersionUID = -2347797235335528420L;

	@NotBlank(message = "{usuario.form.requerido.nombre}")
	@Size(max = 60)
	private String username;

	@NotBlank(message = "{usuario.form.requerido.password}")
	@Size(max = 120)
	private String password;
}
