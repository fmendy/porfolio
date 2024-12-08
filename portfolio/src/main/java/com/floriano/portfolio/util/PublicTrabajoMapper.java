package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.floriano.portfolio.entity.Habilidad;
import com.floriano.portfolio.entity.Trabajo;
import com.floriano.portfolio.entity.TrabajoHabilidad;
import com.floriano.portfolio.entity.TrabajoTarea;
import com.floriano.portfolio.model.publico.PublicTrabajoForm;
import com.floriano.portfolio.model.publico.PublicTrabajoTareaForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PublicTrabajoMapper {

	public List<PublicTrabajoForm> listTrabajoToListPublicTrabajoForm(List<Trabajo> list) {
		List<PublicTrabajoForm> retVal = new ArrayList<PublicTrabajoForm>();
		for (Trabajo t : list) {
			retVal.add(trabajoToPublicTrabajoForm(t));
		}
		return retVal;
	}

	public PublicTrabajoForm trabajoToPublicTrabajoForm(Trabajo trabajo) {
		PublicTrabajoForm retVal = new PublicTrabajoForm();
		retVal.setEmpresaNombre(trabajo.getEmpresa().getNombre());
		retVal.setNombre(trabajo.getNombre());

		if (trabajo.getMunicipio() != null) {
			retVal.setLugarDeTrabajo(trabajo.getMunicipio().getNombre() + ", " + trabajo.getProvincia().getNombre()
					+ ", " + trabajo.getPais().getNombre());
		} else if (trabajo.getProvincia() != null) {
			retVal.setLugarDeTrabajo(trabajo.getProvincia().getNombre() + ", " + trabajo.getPais().getNombre());
		} /*
			 * else if (trabajo.getComunidadAutonoma() != null) {
			 * retVal.setLugarDeTrabajo(trabajo.getComunidadAutonoma().getNombre() + ", " +
			 * trabajo.getPais().getNombre()); }
			 */else if (trabajo.getOtraUbicacion() != null) {
			retVal.setLugarDeTrabajo(trabajo.getOtraUbicacion() + ", " + trabajo.getPais().getNombre());
		} else {
			retVal.setLugarDeTrabajo(trabajo.getPais().getNombre());
		}

		Calendar calendarFechaInicio = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
		calendarFechaInicio.setTime(trabajo.getFechaInicio());
		Calendar calendarActual = Calendar.getInstance();

		if (trabajo.getFechaFin() == null) {
			retVal.setAnosTrabajo(Integer.toString(calendarFechaInicio.get(Calendar.YEAR)) + " - Actual");
			if (calendarFechaInicio.get(Calendar.YEAR) == calendarActual.get(Calendar.YEAR)) {
				retVal.setDuracionTrabajo(
						(calendarActual.get(Calendar.MONTH) - calendarFechaInicio.get(Calendar.MONTH) + 1) + " Meses");
			} else {
				retVal.setDuracionTrabajo(
						calendarActual.get(Calendar.YEAR) - calendarFechaInicio.get(Calendar.YEAR) + " Años");
			}
		} else {
			Calendar calendarFechaFin = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
			calendarFechaFin.setTime(trabajo.getFechaFin());

			if (calendarFechaInicio.get(Calendar.YEAR) != calendarFechaFin.get(Calendar.YEAR)) {
				retVal.setAnosTrabajo(Integer.toString(calendarFechaInicio.get(Calendar.YEAR)) + " - "
						+ Integer.toString(calendarFechaFin.get(Calendar.YEAR)));
				retVal.setDuracionTrabajo(
						calendarFechaFin.get(Calendar.YEAR) - calendarFechaInicio.get(Calendar.YEAR) + " Años");
			} else {
				retVal.setAnosTrabajo(Integer.toString(calendarFechaInicio.get(Calendar.YEAR)));
				retVal.setDuracionTrabajo(
						(calendarFechaFin.get(Calendar.MONTH) - calendarFechaInicio.get(Calendar.MONTH) + 1)
								+ " Meses");
			}
		}

		retVal.setObservaciones(trabajo.getObservaciones());
		List<Habilidad> listHabilidad = new ArrayList<>();
		for (TrabajoHabilidad th : trabajo.getListTrabajoHabilidad()) {
			listHabilidad.add(th.getHabilidad());
		}
		retVal.setListHabilidad(PublicHabilidadMapper.listHabilidadToListPublicHabilidadForm(listHabilidad));

		List<PublicTrabajoTareaForm> listPublicTrabajoTarea = new ArrayList<>();
		for (TrabajoTarea tt : trabajo.getListTrabajoTarea()) {
			PublicTrabajoTareaForm f = new PublicTrabajoTareaForm();
			f.setNombre(tt.getNombre());
			listPublicTrabajoTarea.add(f);
		}

		retVal.setListTrabajoTarea(listPublicTrabajoTarea);

		return retVal;
	}
}
