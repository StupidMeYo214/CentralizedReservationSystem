package com.utdallas.classes;

import java.util.ArrayList;

public class Department {

	private String departmentName;
	private String departmentID;
	private String departmentAddress;
	private String contactEmail;
	private String contactPhone;
	private String img;
	private ArrayList<Facility> facilityList;

	public ArrayList<Facility> getFacilityList() {
		return facilityList;
	}

	public void setFacilityList(ArrayList<Facility> facilityList) {
		this.facilityList = facilityList;
	}

	public void setDepartment(String departmentName, String departmentID, String departmentAddress, String contactEmail, String contactPhone,String img){
	
		this.departmentName = departmentName;
		this.departmentID = departmentID;
		this.departmentAddress = departmentAddress;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.img = img;
		
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	
}
