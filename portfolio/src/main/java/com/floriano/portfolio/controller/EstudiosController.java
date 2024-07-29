package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.floriano.portfolio.service.EstudioService;

@Controller
@RequestMapping(value = "/estudios")
public class EstudiosController extends BaseController{

	@Autowired
	private EstudioService estudioService;

	@GetMapping(value = "")
	public String indexEstudios(Model model) {
		model.addAttribute("titulo", "Gómez Floriano, Jorge - Estudios");
		model.addAttribute("listEstudios", estudioService.getAllActivosPublic());
		addBasicModelDetails(model);
		addNavbarCurrentPage(model, "estudios");
		return "estudios";
	}

}
