package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.entity.Curso;
import com.floriano.portfolio.form.publico.PublicCursoForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PublicCursoMapper {

	public PublicCursoForm cursoToPublicCursoForm(Curso curso) {
		PublicCursoForm retVal = new PublicCursoForm();
		retVal.setDuracion(curso.getDuracion());
		retVal.setFecha(curso.getFecha());
		retVal.setNombre(curso.getNombre());
		if (curso.getInstitucionEductativa() != null) {
			retVal.setInstitucionEductativaNombre(curso.getInstitucionEductativa().getNombre());
			retVal.setInstitucionEductativaWeb(curso.getInstitucionEductativa().getUrl());
		}
		return retVal;
	}

	public List<PublicCursoForm> listCursoToListPublicCursoForm(List<Curso> list) {
		List<PublicCursoForm> retVal = new ArrayList<>();
		for (Curso c : list) {
			retVal.add(cursoToPublicCursoForm(c));
		}
		return retVal;
	}
}
