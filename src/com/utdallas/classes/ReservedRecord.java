package com.utdallas.classes;

import java.util.ArrayList;

public class ReservedRecord {
	private String usrname;
	private String department;
	private String facility_id;
	private String facility_name;
	private String date;
	private String timeslot;
	private String reservation_id;
	private User user;


	private ArrayList<Facility> facilityList;

	public ReservedRecord(String usrname,String department,String facility_id,String facility_name,String date,String timeslot,String reservation_id) {
		// TODO Auto-generated constructor stub
		this.facility_id = facility_id;
		this.usrname = usrname;
		this.department = department;
		this.facility_name = facility_name;
		this.timeslot = timeslot;
		this.date = date;
		this.reservation_id = reservation_id;
	}
	
	
	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getFacility_name() {
		return facility_name;
	}

	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	public String getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}
	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getfacility_name() {
		return facility_name;
	}

	public void setfacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public ArrayList<Facility> getFacilityList() {
		return facilityList;
	}


	public void setFacilityList(ArrayList<Facility> facilityList) {
		this.facilityList = facilityList;
	}
	
}
