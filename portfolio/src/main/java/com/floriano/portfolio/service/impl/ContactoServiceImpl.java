package com.floriano.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.floriano.portfolio.dto.filter.ContactoFilter;
import com.floriano.portfolio.dto.privado.PrivadoContactoForm;
import com.floriano.portfolio.dto.publico.PublicoContactoForm;
import com.floriano.portfolio.dto.specifications.ContactoSpecifications;
import com.floriano.portfolio.model.Contacto;
import com.floriano.portfolio.repository.ContactoRepository;
import com.floriano.portfolio.service.ContactoService;
import com.floriano.portfolio.util.ContactoUtil;

@Service
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;

	@Override
	public Long enviarContacto(PublicoContactoForm form) {
		Contacto contacto = ContactoUtil.publicContactoFormToContacto(form);
		contactoRepository.saveAndFlush(contacto);
		return contacto.getId();
	}

	@Override
	public Page<PrivadoContactoForm> getPageSearch(ContactoFilter filter, Pageable pageable) {
		return ContactoUtil.pageContactoToPagePrivadoContacto(
				contactoRepository.findAll(ContactoSpecifications.filter(filter), pageable));
	}
}
