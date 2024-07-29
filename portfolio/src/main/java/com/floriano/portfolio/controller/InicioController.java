package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.floriano.portfolio.service.UsuarioService;

@Controller
public class InicioController extends BaseController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/")
	public String init(Model model) {
		model.addAttribute("titulo", "Gómez Floriano");
		usuarioService.getById(1L);
		addBasicModelDetails(model);
		addNavbarCurrentPage(model, "inicio");
		return "inicio";
	}
	
}
