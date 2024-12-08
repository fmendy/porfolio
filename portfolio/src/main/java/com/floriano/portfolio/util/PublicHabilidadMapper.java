package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.entity.Habilidad;
import com.floriano.portfolio.model.publico.PublicHabilidadForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PublicHabilidadMapper {

	public List<PublicHabilidadForm> listHabilidadToListPublicHabilidadForm(List<Habilidad> list) {
		List<PublicHabilidadForm> retVal = new ArrayList<>();
		for (Habilidad habilidad : list) {
			retVal.add(habilidadToPublicHabilidadForm(habilidad));
		}
		return retVal;
	}

	public PublicHabilidadForm habilidadToPublicHabilidadForm(Habilidad habilidad) {
		PublicHabilidadForm retVal = new PublicHabilidadForm();
		retVal.setNombre(habilidad.getNombre());
		return retVal;
	}
}
