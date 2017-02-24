package com.utdallas.classes;

import java.util.Date;

public class Reservation {

	private User user;
	private Facility facility;
	private String reservationId;

	private String date;
	private String timeslot;
	private String reserved;
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Reservation(String date, String timeslot, String reserved, String username, String reservationId) {
		// TODO Auto-generated constructor stub
		this.date = date;
		this.timeslot = timeslot;
		this.reserved = reserved;
		this.username = username;
		this.reservationId = reservationId;	}
	
	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}
