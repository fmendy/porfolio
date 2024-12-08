package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoEstudioObservacionForm;
import com.floriano.portfolio.model.EstudioObservacion;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EstudioObservacionUtil {

	public PublicoEstudioObservacionForm estudioObservacionToPublicEstudioObservacionForm(EstudioObservacion bean) {
		PublicoEstudioObservacionForm retVal = new PublicoEstudioObservacionForm();
		retVal.setNombre(bean.getNombre());
		retVal.setObservacion(bean.getObservacion());
		return retVal;
	}

	public List<PublicoEstudioObservacionForm> listEstudioObservacionToListPublicEstudioObservacionForm(
			List<EstudioObservacion> list) {
		List<PublicoEstudioObservacionForm> retVal = new ArrayList<>();
		for (EstudioObservacion eo : list) {
			retVal.add(estudioObservacionToPublicEstudioObservacionForm(eo));
		}
		return retVal;
	}
}
