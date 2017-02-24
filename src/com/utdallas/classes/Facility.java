package com.utdallas.classes;

import java.util.ArrayList;

public class Facility {

	private String facilityName;
	private String facilityID;
	private String dpt;
	private String dptID;
	private String restrictionLevel;
	private String description;
	private ArrayList<Reservation> availabilityList;
	


	public void setFacility(String facilityName,String facilityID, String dpt,String dptID, String restrictionLevel,String description){
		this.facilityName=facilityName;
		this.facilityID = facilityID;
		this.dpt = dpt;
		this.dptID = dptID;
		this.restrictionLevel = restrictionLevel;
		this.description = description;
	}
	
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	public String getDpt() {
		return dpt;
	}
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}
	public String getDptID() {
		return dptID;
	}
	public void setDptID(String dptID) {
		this.dptID = dptID;
	}
	public String getRestrictionLevel() {
		return restrictionLevel;
	}
	public void setRestrictionLevel(String restrictionLevel) {
		this.restrictionLevel = restrictionLevel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public ArrayList<Reservation> getAvailabilityList() {
		return availabilityList;
	}

	public void setAvailabilityList(ArrayList<Reservation> availabilityList) {
		this.availabilityList = availabilityList;
	}
	
}
