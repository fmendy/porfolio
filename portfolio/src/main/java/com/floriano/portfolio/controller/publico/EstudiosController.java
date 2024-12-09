package com.floriano.portfolio.controller.publico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.controller.BaseController;
import com.floriano.portfolio.service.EstudioService;
import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Util;

@Controller
@RequestMapping(value = "/estudios")
public class EstudiosController extends BaseController {

	@Autowired
	private EstudioService estudioService;

	@GetMapping(value = "")
	public ModelAndView indexEstudios() {
		ModelAndView mav = new ModelAndView("publico/estudios");
		mav.addObject(Constantes.TITLE_PAGE, Util.getMessage("title.page.gomez.floriano.jorge")+" "+Constantes.GUION +" "+Util.getMessage("title.page.estudios"));
		mav.addObject("listEstudios", estudioService.getAllActivosPublic());
		addBasicModelDetails(mav);
		return mav;
	}

}
