package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.floriano.portfolio.dto.privado.PrivadoContactoForm;
import com.floriano.portfolio.dto.publico.PublicoContactoForm;
import com.floriano.portfolio.model.Contacto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ContactoUtil {

	public Contacto publicContactoFormToContacto(PublicoContactoForm form) {
		Contacto retVal = new Contacto();
		retVal.setMail(form.getMail());
		retVal.setAsunto(form.getAsunto());
		retVal.setTitulo(form.getTitulo());
		return retVal;
	}

	public PrivadoContactoForm contactoToPrivadoForm(Contacto contacto) {
		if (contacto == null) {
			return new PrivadoContactoForm();
		}
		PrivadoContactoForm retVal = new PrivadoContactoForm();
		retVal.setId(contacto.getId());
		retVal.setAsunto(contacto.getAsunto());
		retVal.setFecha(contacto.getFechaCreacion());
		retVal.setLeido(contacto.isLeido());
		retVal.setMail(contacto.getMail());
		retVal.setRespondido(contacto.isRespondido());
		retVal.setTitulo(contacto.getTitulo());

		return retVal;
	}

	public List<PrivadoContactoForm> listContactoToListPrivadoContactoForm(List<Contacto> list) {
		List<PrivadoContactoForm> retVal = new ArrayList<>();
		for (Contacto privado : list) {
			retVal.add(contactoToPrivadoForm(privado));
		}
		return retVal;
	}

	public Page<PrivadoContactoForm> pageContactoToPagePrivadoContacto(Page<Contacto> page) {
		Page<PrivadoContactoForm> retVal = new PageImpl<PrivadoContactoForm>(
				listContactoToListPrivadoContactoForm(page.getContent()), page.getPageable(), page.getTotalElements());
		return retVal;
	}
}
