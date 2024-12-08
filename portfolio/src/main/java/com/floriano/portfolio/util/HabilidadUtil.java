package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoHabilidadForm;
import com.floriano.portfolio.model.Habilidad;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HabilidadUtil {

	public List<PublicoHabilidadForm> listHabilidadToListPublicHabilidadForm(List<Habilidad> list) {
		List<PublicoHabilidadForm> retVal = new ArrayList<>();
		for (Habilidad habilidad : list) {
			retVal.add(habilidadToPublicHabilidadForm(habilidad));
		}
		return retVal;
	}

	public PublicoHabilidadForm habilidadToPublicHabilidadForm(Habilidad habilidad) {
		PublicoHabilidadForm retVal = new PublicoHabilidadForm();
		retVal.setNombre(habilidad.getNombre());
		return retVal;
	}
}
