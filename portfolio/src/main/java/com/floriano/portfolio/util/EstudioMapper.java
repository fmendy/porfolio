package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.entity.Estudio;
import com.floriano.portfolio.form.publico.PublicEstudioForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EstudioMapper {

	public PublicEstudioForm estudioToPublicEstudioForm(Estudio estudio) {
		PublicEstudioForm retVal = new PublicEstudioForm();
		retVal.setInstitucionEducativaNombre(estudio.getInstitucionEductativa().getNombre());
		retVal.setInstitucionEducativaUrl(estudio.getInstitucionEductativa().getUrl());
		retVal.setNivelEqfMec(estudio.getNivelEqfMec());
		retVal.setNombre(estudio.getNombre());
		retVal.setListEstudioObservacion(EstudioObservacionMapper
				.listEstudioObservacionToListPublicEstudioObservacionForm(estudio.getListEstudioObservacion()));
		retVal.setFechaFin(Util.dateToMesAnnoString(estudio.getFechaFin()));
		retVal.setFechaInicio(Util.dateToMesAnnoString(estudio.getFechaInicio()));
		retVal.setAnoFin(Util.dateToAnno(estudio.getFechaFin()));
		retVal.setAnoInicio(Util.dateToAnno(estudio.getFechaInicio()));
		return retVal;
	}

	public List<PublicEstudioForm> listEstudioToListPublicEstudioForm(List<Estudio> list) {
		List<PublicEstudioForm> retVal = new ArrayList<>();
		for (Estudio e : list) {
			retVal.add(estudioToPublicEstudioForm(e));
		}
		return retVal;
	}
}
