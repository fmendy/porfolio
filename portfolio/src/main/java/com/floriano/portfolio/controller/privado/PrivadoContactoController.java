package com.floriano.portfolio.controller.privado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.dto.filter.ContactoFilter;
import com.floriano.portfolio.dto.privado.PrivadoContactoForm;
import com.floriano.portfolio.service.ContactoService;
import com.floriano.portfolio.service.RolService;
import com.floriano.portfolio.service.UsuarioService;
import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Utils;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/privado/contacto")
@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
public class PrivadoContactoController {

	Logger logger = LoggerFactory.getLogger(PrivadoUsuarioController.class);

	@Autowired
	private ContactoService contactoService;



	private static final String VIEW_LIST = "privado/contacto/list";

	private static final String VIEW_DETAILS = "privado/contacto/details";
	
	
	@GetMapping("")
	public ModelAndView displayAll(Pageable pageable, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(VIEW_LIST);
		defaultModel(mav, new ContactoFilter(), pageable, request);
		return mav;
	}
	
	private void defaultModel(ModelAndView mav, ContactoFilter filter, Pageable pageable, HttpServletRequest request) {
		mav.addObject("page", contactoService.getPageSearch(filter, pageable));
		mav.addObject("filter", filter);
		mav.addObject("url", Utils.urlBuscarContacto(request.getRequestURI(), filter));
		mav.addObject("sort", Utils.getParameterSort(pageable.getSort()));
		mav.addObject(Constantes.TITLE_PAGE, Utils.getMessage("title.page.gomez.floriano.jorge") + " " + Constantes.GUION
				+ " " + Utils.getMessage("title.page.contacto"));
	}

	
}
