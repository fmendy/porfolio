package com.floriano.portfolio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.floriano.portfolio.dto.filter.ContactoFilter;
import com.floriano.portfolio.dto.privado.PrivadoContactoForm;
import com.floriano.portfolio.dto.publico.PublicoContactoForm;

public interface ContactoService {

	Long enviarContacto(PublicoContactoForm form);

	Page<PrivadoContactoForm> getPageSearch(ContactoFilter filter, Pageable pageable);
}
