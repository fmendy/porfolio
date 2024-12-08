package com.floriano.portfolio.controller.privado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/privado/certiciacion")
@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
public class PrivadoCertificacionController {
	
	
	Logger logger = LoggerFactory.getLogger(PrivadoCertificacionController.class);

	private static final String TITLE_PAGE = "title.entrevista";

	private static final String VIEW_DETAILS = "mapa/details";

	@GetMapping("")
	public ModelAndView display(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(VIEW_DETAILS);
		mav.addObject(TITLE_PAGE, "certificacion");
		return mav;
	}


}
