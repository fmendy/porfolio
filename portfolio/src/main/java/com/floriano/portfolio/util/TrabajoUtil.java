package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.floriano.portfolio.model.Habilidad;
import com.floriano.portfolio.model.Trabajo;
import com.floriano.portfolio.model.TrabajoHabilidad;
import com.floriano.portfolio.model.TrabajoTarea;
import com.floriano.portfolio.dto.publico.PublicoTrabajoForm;
import com.floriano.portfolio.dto.publico.PublicoTrabajoTareaForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TrabajoUtil {

	public List<PublicoTrabajoForm> listTrabajoToListPublicTrabajoForm(List<Trabajo> list) {
		List<PublicoTrabajoForm> retVal = new ArrayList<PublicoTrabajoForm>();
		for (Trabajo t : list) {
			retVal.add(trabajoToPublicTrabajoForm(t));
		}
		return retVal;
	}

	public PublicoTrabajoForm trabajoToPublicTrabajoForm(Trabajo trabajo) {
		PublicoTrabajoForm retVal = new PublicoTrabajoForm();
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
		retVal.setListHabilidad(HabilidadUtil.listHabilidadToListPublicHabilidadForm(listHabilidad));

		List<PublicoTrabajoTareaForm> listPublicTrabajoTarea = new ArrayList<>();
		for (TrabajoTarea tt : trabajo.getListTrabajoTarea()) {
			PublicoTrabajoTareaForm f = new PublicoTrabajoTareaForm();
			f.setNombre(tt.getNombre());
			listPublicTrabajoTarea.add(f);
		}

		retVal.setListTrabajoTarea(listPublicTrabajoTarea);

		return retVal;
	}
}
