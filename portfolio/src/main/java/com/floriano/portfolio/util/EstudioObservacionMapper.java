package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.entity.EstudioObservacion;
import com.floriano.portfolio.form.publico.PublicEstudioObservacionForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EstudioObservacionMapper {

	public PublicEstudioObservacionForm estudioObservacionToPublicEstudioObservacionForm(EstudioObservacion bean) {
		PublicEstudioObservacionForm retVal = new PublicEstudioObservacionForm();
		retVal.setNombre(bean.getNombre());
		retVal.setObservacion(bean.getObservacion());
		return retVal;
	}

	public List<PublicEstudioObservacionForm> listEstudioObservacionToListPublicEstudioObservacionForm(
			List<EstudioObservacion> list) {
		List<PublicEstudioObservacionForm> retVal = new ArrayList<>();
		for (EstudioObservacion eo : list) {
			retVal.add(estudioObservacionToPublicEstudioObservacionForm(eo));
		}
		return retVal;
	}
}
