package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.floriano.portfolio.service.CursoService;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController extends BaseController {

	@Autowired
	private CursoService cursoService;

	@GetMapping(value = "")
	public String indexCursos(Model model) {
		model.addAttribute("titulo", "Gómez Floriano, Jorge - Cursos");
		model.addAttribute("listCursos", cursoService.getAllActivosPublic());
		addBasicModelDetails(model);
		addNavbarCurrentPage(model, "cursos");
		return "cursos";
	}
}
