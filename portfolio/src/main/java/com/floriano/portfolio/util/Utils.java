package com.floriano.portfolio.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import com.floriano.portfolio.dto.filter.ContactoFilter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

	public String dateToMesAnnoString(Date date) {

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);

		// Obtienes el mes actual
		Month mes = Month.of(month);
		// Obtienes el nombre del mes
		String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		return nombreMes + " " + year;
	}

	public String dateToAnno(Date date) {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
		cal.setTime(date);

		return Integer.toString(cal.get(Calendar.YEAR));
	}

	public String getMessage(String key) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.getDefault());
		return resourceBundle.getString(key);
	}

	public String getParameterSort(Sort sort) {
		if (sort != null && StringUtils.hasText(sort.toString()) && !sort.toString().equalsIgnoreCase("UNSORTED")) {
			String[] aux = sort.toString().split(" ");
			return "&sort=" + aux[0].trim().replace(":", "") + "," + aux[1].trim().replace(":", "");
		}
		return "";
	}

	public String urlBuscarContacto(String url, ContactoFilter filter) {
		String retVal = url;
		if (retVal.indexOf("?") < 0) {
			retVal = retVal + "?";
		}
		if (filter != null) {
			if (StringUtils.hasText(filter.getMail())) {
				retVal = retVal + "&mail=" + filter.getMail();
			}
			if (filter.getAsunto() != null) {
				retVal = retVal + "&asunto=" + filter.getAsunto();
			}
			if (filter.getFechaDesde() != null) {
				retVal = retVal + "&fechaDesde="
						+ dateToString(filter.getFechaDesde(), Constantes.DATE_FORMAT_YYYY_MM_DD);
			}
			if (filter.getFechaHasta() != null) {
				retVal = retVal + "&fechaHasta="
						+ dateToString(filter.getFechaHasta(), Constantes.DATE_FORMAT_YYYY_MM_DD);
			}
			if (filter.getLeido() != null) {
				retVal = retVal + "&leido=" + filter.getLeido();
			}
			if (filter.getRespondido() != null) {
				retVal = retVal + "&respondido=" + filter.getRespondido();
			}
		}
		return retVal;
	}

	public Date dateSetHoraMinutoSegundoMilisegundo(Date date, int hora, int min, int sec, int milisec) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hora);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, sec);
		cal.set(Calendar.MILLISECOND, milisec);
		return cal.getTime();
	}

	public String dateToString(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
}
