package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.utdallas.classes.Reservation;

public class ReservationList {
	private ArrayList<Reservation> reservations = new ArrayList<>();
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public ArrayList<Reservation> getReserveList(String departmentName, String facilityId, String date){
		//ArrayList<Reservation> reservations = new ArrayList<>();
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from "+departmentName+"_facility_"+facilityId+" where Date='"+date+"' and reserved='0';");
			while(resultSet.next()){
				String reservationId = resultSet.getString(1);
				String date1 = resultSet.getString(2);
				String timeslot = resultSet.getString(3);
				String reserved = resultSet.getString(4);
				String username = resultSet.getString(5);
				Reservation reservation = new Reservation(date1, timeslot, reserved,username,reservationId);
				reservations.add(reservation);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				if(connection!=null){
					connection.close();
					connection=null;
				}
				if(statement != null){
					statement.close();
					statement=null;
				}
				if(resultSet != null){
					resultSet.close();
					resultSet=null;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		return reservations;
	}
}
