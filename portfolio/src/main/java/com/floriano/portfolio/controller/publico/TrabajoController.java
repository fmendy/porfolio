package com.floriano.portfolio.controller.publico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.controller.BaseController;
import com.floriano.portfolio.service.TrabajoService;
import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Utils;

@Controller
@RequestMapping(value = "/trabajos")
public class TrabajoController extends BaseController {

	@Autowired
	private TrabajoService trabajoService;

	@GetMapping(value = "")
	public ModelAndView indexTrabajo() {
		ModelAndView mav = new ModelAndView("publico/trabajos");
		mav.addObject(Constantes.TITLE_PAGE, Utils.getMessage("title.page.gomez.floriano.jorge") + " " + Constantes.GUION
				+ " " + Utils.getMessage("title.page.experiencia.laboral"));
		mav.addObject("listTrabajos", trabajoService.getPublicTrabajos());
		addBasicModelDetails(mav);
		return mav;
	}
}
