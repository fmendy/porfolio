package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.service.CursoService;
import com.floriano.portfolio.util.Constantes;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController extends BaseController {

	@Autowired
	private CursoService cursoService;

	@GetMapping(value = "")
	public ModelAndView indexCursos() {
		ModelAndView mav = new ModelAndView("cursos");
		mav.addObject(Constantes.TITLE_PAGE, "Gómez Floriano, Jorge - Cursos");
		mav.addObject("listCursos", cursoService.getAllActivosPublic());
		addBasicModelDetails(mav);
		return mav;
	}
}
