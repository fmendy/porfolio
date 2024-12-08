package com.floriano.portfolio.controller.privado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.floriano.portfolio.filter.UsuarioFilter;
import com.floriano.portfolio.service.RolService;
import com.floriano.portfolio.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/privado/administracion/usuario")
@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
public class PrivadoUsuarioController {

	Logger logger = LoggerFactory.getLogger(PrivadoUsuarioController.class);

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RolService rolService;

	private static final String TITLE_PAGE = "title.usuario";

	private static final String VIEW_LIST = "usuario/list";

	private static final String VIEW_DETAILS = "usuario/details";

/*	@GetMapping("")
	public ModelAndView displayAll(Pageable pageable, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(VIEW_LIST);
		defaultModel(mav, new UsuarioFilter(), pageable, request);
		return mav;
	}

	@GetMapping("/buscar")
	public ModelAndView search(Pageable pageable, HttpServletRequest request, UsuarioFilter filter) {
		ModelAndView mav = new ModelAndView(VIEW_LIST);
		defaultModel(mav, filter, pageable, request);
		return mav;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(VIEW_DETAILS);
		defaultModelDetails(mav, usuarioService.getById(id));
		return mav;
	}

	@GetMapping("/crear")
	public ModelAndView edit(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(VIEW_DETAILS);
		defaultModelDetails(mav, new UsuarioForm());
		return mav;
	}

	@GetMapping("/miperfil")
	public ModelAndView miPerfil(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(VIEW_DETAILS);
		defaultModelDetails(mav, usuarioService.getById(
				usuarioService.getIdByUsername(SecurityContextHolder.getContext().getAuthentication().getName())));
		return mav;
	}

	@PostMapping("/guardar")
	public ModelAndView guardar(@Valid @ModelAttribute("form") UsuarioForm form, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes) {
		ModelAndView mav = new ModelAndView(VIEW_DETAILS);
		Long idUsuario;
		if (!usuarioService.isValidUsuario(bindingResult, form)) {
			defaultModelDetails(mav, form);
			return mav;
		}
		try {
			idUsuario = usuarioService.save(form);
		} catch (Exception e) {
			defaultModelDetails(mav, form);
			attributes.addFlashAttribute("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR.value());
			logger.error(e.toString());
			return mav;
		}
		defaultModelDetails(mav, usuarioService.getById(idUsuario));
		mav.addObject("httpStatus", HttpStatus.OK.value());
		return mav;
	}

	private void defaultModel(ModelAndView mav, UsuarioFilter filter, Pageable pageable, HttpServletRequest request) {
		mav.addObject("page", usuarioService.getPageSearch(filter, pageable));
		mav.addObject("filter", filter);
		mav.addObject("url", Utils.urlBuscarUsuario(request.getRequestURI(), filter));
		mav.addObject("sort", Utils.getParameterSort(pageable.getSort()));
		mav.addObject("title", Utils.getMessage(TITLE_PAGE));
		mav.addObject("listRol", rolService.getListForm());
	}

	private void defaultModelDetails(ModelAndView mav, UsuarioForm form) {
		mav.addObject("form", form);
		mav.addObject("listRol", rolService.getListForm());
		mav.addObject("title", Util.getMessage(TITLE_PAGE));
	}*/

}
