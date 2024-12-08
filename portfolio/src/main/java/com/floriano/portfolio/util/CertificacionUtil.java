package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoCertificacionForm;
import com.floriano.portfolio.model.Certificacion;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CertificacionUtil {

	public PublicoCertificacionForm certificacionToPublicCertificacionForm(Certificacion certificacion) {
		PublicoCertificacionForm retVal = new PublicoCertificacionForm();
		retVal.setCertificateNumber(certificacion.getCertificateNumber());
		retVal.setImagen(certificacion.getImagen());
		retVal.setNombre(certificacion.getNombre());
		retVal.setUrl(certificacion.getUrl());
		return retVal;
	}

	public List<PublicoCertificacionForm> listCertificacionToListPublicCertificacionForm(List<Certificacion> list) {
		List<PublicoCertificacionForm> retVal = new ArrayList<>();
		for (Certificacion c : list) {
			retVal.add(certificacionToPublicCertificacionForm(c));
		}
		return retVal;
	}
}
