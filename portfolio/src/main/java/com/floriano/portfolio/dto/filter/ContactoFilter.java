package com.floriano.portfolio.dto.filter;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactoFilter implements Serializable {

	private static final long serialVersionUID = -1503129475490786294L;

	private String mail;

	private String asunto;

	private Long leido;

	private Long respondido;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaDesde;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaHasta;

}
