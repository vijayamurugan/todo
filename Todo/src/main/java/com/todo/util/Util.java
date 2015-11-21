package com.todo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Utility Class
 * 
 * @author Vijayamurugan D
 *
 */
public class Util {

	public static int getDiffYears(Date last) {
		Date today = new Date();
		long diff = today.getTime() - last.getTime();
		return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		return cal;
	}

	public static Date getOldDate() {

		SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = dateformat3.parse("21/11/2013");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
