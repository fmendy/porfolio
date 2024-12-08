package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.dto.publico.PublicoCursoForm;
import com.floriano.portfolio.model.Curso;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CursoUtil {

	public PublicoCursoForm cursoToPublicCursoForm(Curso curso) {
		PublicoCursoForm retVal = new PublicoCursoForm();
		retVal.setDuracion(curso.getDuracion());
		retVal.setFecha(curso.getFecha());
		retVal.setNombre(curso.getNombre());
		if (curso.getInstitucionEductativa() != null) {
			retVal.setInstitucionEductativaNombre(curso.getInstitucionEductativa().getNombre());
			retVal.setInstitucionEductativaWeb(curso.getInstitucionEductativa().getUrl());
		}
		return retVal;
	}

	public List<PublicoCursoForm> listCursoToListPublicCursoForm(List<Curso> list) {
		List<PublicoCursoForm> retVal = new ArrayList<>();
		for (Curso c : list) {
			retVal.add(cursoToPublicCursoForm(c));
		}
		return retVal;
	}
}
