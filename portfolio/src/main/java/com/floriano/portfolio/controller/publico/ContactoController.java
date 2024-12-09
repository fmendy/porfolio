package com.floriano.portfolio.controller.publico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.floriano.portfolio.controller.BaseController;
import com.floriano.portfolio.dto.publico.PublicoContactoForm;
import com.floriano.portfolio.service.ContactoService;
import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/contacto")
public class ContactoController extends BaseController {

	@Autowired
	private ContactoService contactoService;

	private static final String VIEW_PUBLICO_CONTACTO = "publico/contacto";

	@GetMapping(value = "")
	public ModelAndView indexCursos(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(VIEW_PUBLICO_CONTACTO);
		addBasicModelDetails(mav);
		defaultModelForm(mav, new PublicoContactoForm());
		return mav;

	}

	@PostMapping("/guardar")
	public ModelAndView guardar(@Valid @ModelAttribute("form") PublicoContactoForm form, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView(VIEW_PUBLICO_CONTACTO);
		if (bindingResult.hasErrors()) {
			defaultModelForm(mav, form);
			return mav;
		}

		try {
			contactoService.enviarContacto(form);
		} catch (Exception e) {
			mav.addObject("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR.value());
			defaultModelForm(mav, form);
			return mav;
		}

		RedirectView rv = new RedirectView(VIEW_PUBLICO_CONTACTO);
		mav = new ModelAndView(rv);
		redirectAttributes.addFlashAttribute("httpStatus", HttpStatus.OK.value());
		defaultModelForm(mav, new PublicoContactoForm());
		return mav;
	}

	private void defaultModelForm(ModelAndView mav, PublicoContactoForm form) {
		mav.addObject("form", form);
		mav.addObject(Constantes.TITLE_PAGE, Utils.getMessage("title.page.gomez.floriano.jorge") + " "
				+ Constantes.GUION + " " + Utils.getMessage("title.page.contacto"));
	}
}
