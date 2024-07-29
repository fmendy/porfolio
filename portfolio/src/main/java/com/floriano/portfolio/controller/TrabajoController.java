package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.floriano.portfolio.service.TrabajoService;

@Controller
@RequestMapping(value = "/experiencia")
public class TrabajoController extends BaseController {

	@Autowired
	private TrabajoService trabajoService;

	@GetMapping(value = "")
	public String indexTrabajo(Model model) {
		model.addAttribute("titulo", "Gómez Floriano, Jorge - Experiencia");
		model.addAttribute("listTrabajos", trabajoService.getPublicTrabajos());
		addBasicModelDetails(model);
		addNavbarCurrentPage(model, "experiencia");
		return "trabajos";
	}
}
