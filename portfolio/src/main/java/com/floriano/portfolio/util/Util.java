package com.floriano.portfolio.util;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

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
}
