package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.service.TrabajoService;
import com.floriano.portfolio.util.Constantes;

@Controller
@RequestMapping(value = "/experiencia")
public class TrabajoController extends BaseController {

	@Autowired
	private TrabajoService trabajoService;

	@GetMapping(value = "")
	public ModelAndView indexTrabajo() {
		ModelAndView mav = new ModelAndView("trabajos");
		mav.addObject(Constantes.TITLE_PAGE, "Gómez Floriano, Jorge - Experiencia");
		mav.addObject("listTrabajos", trabajoService.getPublicTrabajos());
		addBasicModelDetails(mav);
		return mav;
	}
}
