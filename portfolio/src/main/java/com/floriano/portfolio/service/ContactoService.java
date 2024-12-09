package com.floriano.portfolio.service;

import com.floriano.portfolio.dto.publico.PublicoContactoForm;

public interface ContactoService {

	Long enviarContacto(PublicoContactoForm form);
}
