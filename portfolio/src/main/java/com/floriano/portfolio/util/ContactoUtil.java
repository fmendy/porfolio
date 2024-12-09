package com.floriano.portfolio.util;

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
}
