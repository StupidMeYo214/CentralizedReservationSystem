package com.utdallas.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDateString {
	public static String getDateString(int i){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, i);
		return dateFormat.format(cal.getTime());
	}
}
