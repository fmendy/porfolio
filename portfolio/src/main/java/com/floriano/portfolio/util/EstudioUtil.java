package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoEstudioForm;
import com.floriano.portfolio.model.Estudio;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EstudioUtil {

	public PublicoEstudioForm estudioToPublicEstudioForm(Estudio estudio) {
		PublicoEstudioForm retVal = new PublicoEstudioForm();
		retVal.setInstitucionEducativaNombre(estudio.getInstitucionEductativa().getNombre());
		retVal.setInstitucionEducativaUrl(estudio.getInstitucionEductativa().getUrl());
		retVal.setNivelEqfMec(estudio.getNivelEqfMec());
		retVal.setNombre(estudio.getNombre());
		retVal.setListEstudioObservacion(EstudioObservacionUtil
				.listEstudioObservacionToListPublicEstudioObservacionForm(estudio.getListEstudioObservacion()));
		retVal.setFechaFin(Utils.dateToMesAnnoString(estudio.getFechaFin()));
		retVal.setFechaInicio(Utils.dateToMesAnnoString(estudio.getFechaInicio()));
		retVal.setAnoFin(Utils.dateToAnno(estudio.getFechaFin()));
		retVal.setAnoInicio(Utils.dateToAnno(estudio.getFechaInicio()));
		return retVal;
	}

	public List<PublicoEstudioForm> listEstudioToListPublicEstudioForm(List<Estudio> list) {
		List<PublicoEstudioForm> retVal = new ArrayList<>();
		for (Estudio e : list) {
			retVal.add(estudioToPublicEstudioForm(e));
		}
		return retVal;
	}
}
