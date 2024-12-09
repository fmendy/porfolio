package com.floriano.portfolio.controller;

import java.util.Date;

import org.springframework.web.servlet.ModelAndView;

import com.floriano.portfolio.util.Constantes;
import com.floriano.portfolio.util.Utils;

public class BaseController {

	public void addBasicModelDetails(ModelAndView mav) {
		mav.addObject(Constantes.ANNO, Utils.dateToAnno(new Date()));
	}

}
