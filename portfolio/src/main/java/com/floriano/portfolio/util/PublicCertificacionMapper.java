package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.entity.Certificacion;
import com.floriano.portfolio.model.publico.PublicCertificacionForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PublicCertificacionMapper {

	public PublicCertificacionForm certificacionToPublicCertificacionForm(Certificacion certificacion) {
		PublicCertificacionForm retVal = new PublicCertificacionForm();
		retVal.setCertificateNumber(certificacion.getCertificateNumber());
		retVal.setImagen(certificacion.getImagen());
		retVal.setNombre(certificacion.getNombre());
		retVal.setUrl(certificacion.getUrl());
		return retVal;
	}

	public List<PublicCertificacionForm> listCertificacionToListPublicCertificacionForm(List<Certificacion> list) {
		List<PublicCertificacionForm> retVal = new ArrayList<>();
		for (Certificacion c : list) {
			retVal.add(certificacionToPublicCertificacionForm(c));
		}
		return retVal;
	}
}
