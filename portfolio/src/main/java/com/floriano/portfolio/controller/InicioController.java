package com.floriano.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.util.Constantes;

@Controller
public class InicioController extends BaseController {

	@GetMapping(value = "/inicio")
	public ModelAndView init(Model model) {
		ModelAndView mav = new ModelAndView("inicio");
		mav.addObject(Constantes.TITLE_PAGE, "Gómez Floriano");
		addBasicModelDetails(mav);
		return mav;
	}

}
