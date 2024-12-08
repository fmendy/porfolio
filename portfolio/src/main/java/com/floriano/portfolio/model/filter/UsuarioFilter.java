package com.floriano.portfolio.model.filter;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioFilter implements Serializable {

	private static final long serialVersionUID = 7282733907446780968L;

	private String nombre;

	private Long rolId;

}
