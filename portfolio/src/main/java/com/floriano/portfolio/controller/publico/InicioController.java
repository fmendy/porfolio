package com.floriano.portfolio.controller.publico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.controller.BaseController;
import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Utils;

@Controller
public class InicioController extends BaseController {

	@GetMapping(value = "/inicio")
	public ModelAndView init(Model model) {
		ModelAndView mav = new ModelAndView("publico/inicio");
		mav.addObject(Constantes.TITLE_PAGE, Utils.getMessage("title.page.gomez.floriano.jorge")+" "+Constantes.GUION +" "+Utils.getMessage("title.page.inicio"));
		addBasicModelDetails(mav);
		return mav;
	}

}
