package com.floriano.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.dto.LoginForm;
import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Util;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		LoginForm form = new LoginForm();
		form.setUsername("Floriano");
		form.setPassword("AS");
		mav.addObject("form", form);
		mav.addObject(Constantes.TITLE_PAGE, Util.getMessage("title.page.iniciar.sesion"));
		return mav;
	}

}