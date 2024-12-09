package com.floriano.portfolio.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.floriano.portfolio.service.VisitaService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class VisitaFilter implements Filter {

	@Autowired
	private VisitaService visitaService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		visitaService.guardarVisita(req.getRequestURL().toString(), req.getRemoteHost());
		chain.doFilter(request, response);
	}

}
