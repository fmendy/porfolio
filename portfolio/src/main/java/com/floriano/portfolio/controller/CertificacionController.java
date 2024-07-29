package com.floriano.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.floriano.portfolio.service.CertificacionService;

@Controller
@RequestMapping(value = "/certificaciones")
public class CertificacionController extends BaseController{

	@Autowired
	private CertificacionService certificacionService;

	@GetMapping(value = "")
	public String indexCursos(Model model) {
		model.addAttribute("titulo", "Gómez Floriano, Jorge - Certificacion");
		model.addAttribute("listCertificaciones", certificacionService.getAllActivosPublic());
		addBasicModelDetails(model);
		addNavbarCurrentPage(model, "certificaciones");
		return "certificaciones";
	}
}
