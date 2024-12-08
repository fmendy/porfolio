package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.service.CertificacionService;
import com.floriano.portfolio.util.Constantes;

@Controller
@RequestMapping(value = "/certificaciones")
public class CertificacionController extends BaseController {

	@Autowired
	private CertificacionService certificacionService;

	@GetMapping(value = "")
	public ModelAndView indexCursos() {
		ModelAndView mav = new ModelAndView("certificaciones");
		mav.addObject(Constantes.TITLE_PAGE, "Gómez Floriano, Jorge - Certificacion");
		mav.addObject("listCertificaciones", certificacionService.getAllActivosPublic());
		addBasicModelDetails(mav);
		return mav;
	}
}
