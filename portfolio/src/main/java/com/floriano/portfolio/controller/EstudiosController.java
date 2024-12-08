package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.service.EstudioService;
import com.floriano.portfolio.util.Constantes;

@Controller
@RequestMapping(value = "/estudios")
public class EstudiosController extends BaseController {

	@Autowired
	private EstudioService estudioService;

	@GetMapping(value = "")
	public ModelAndView indexEstudios() {
		ModelAndView mav = new ModelAndView("estudios");
		mav.addObject(Constantes.TITLE_PAGE, "Gómez Floriano, Jorge - Estudios");
		mav.addObject("listEstudios", estudioService.getAllActivosPublic());
		addBasicModelDetails(mav);
		return mav;
	}

}
