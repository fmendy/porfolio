package com.floriano.portfolio.controller.publico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.controller.BaseController;
import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Util;

@Controller
@RequestMapping(value = "/politicaprivacidad")
public class PoliticaPrivacidadController extends BaseController {

	@GetMapping(value = "")
	public ModelAndView indexTrabajo() {
		ModelAndView mav = new ModelAndView("publico/politicaprivacidad");
		mav.addObject(Constantes.TITLE_PAGE, Util.getMessage("title.page.gomez.floriano.jorge") + " " + Constantes.GUION
				+ " " + Util.getMessage("title.page.politica.privacidad"));
		addBasicModelDetails(mav);
		return mav;
	}
}
