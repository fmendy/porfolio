package com.floriano.portfolio.controller;

import java.util.Date;

import org.springframework.ui.Model;

import com.floriano.portfolio.util.Util;

public class BaseController {

	public void addBasicModelDetails(Model model) {
		model.addAttribute("anno", Util.dateToAnno(new Date()));
	}
	
	public void addNavbarCurrentPage(Model model, String pagina) {
		model.addAttribute("currentPage", pagina);
	}
}
