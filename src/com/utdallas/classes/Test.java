package com.utdallas.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.utdallas.models.CancelReservation;
import com.utdallas.models.DepartmentAdministration;
import com.utdallas.models.GetFacility;
import com.utdallas.models.GetReservation;
import com.utdallas.models.GetAvailableReservation;
import com.utdallas.models.GetDateString;
import com.utdallas.models.MakeReservation;
import com.utdallas.models.ReservationList;
import com.utdallas.models.UserGetter;

public class Test {

	public static void main(String[] args) {
		GetFacility getFacility = new GetFacility();
		getFacility.updateAvailability("ecss", "1");
	}
	
}
