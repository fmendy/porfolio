package com.floriano.portfolio.controller.publico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.controller.BaseController;
import com.floriano.portfolio.service.CursoService;
import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Util;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController extends BaseController {

	@Autowired
	private CursoService cursoService;

	@GetMapping(value = "")
	public ModelAndView indexCursos() {
		ModelAndView mav = new ModelAndView("publico/cursos");
		mav.addObject(Constantes.TITLE_PAGE, Util.getMessage("title.page.gomez.floriano.jorge")+" "+Constantes.GUION +" "+Util.getMessage("title.page.cursos"));
		mav.addObject("listCursos", cursoService.getAllActivosPublic());
		addBasicModelDetails(mav);
		return mav;
	}
}