package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.utdallas.classes.Reservation;

public class GetAvailableReservation {
	
	private Reservation reservation = null;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public Reservation getReservation(String departmentName, String facilityId, String reservationIdIn){
		//ArrayList<Reservation> reservations = new ArrayList<>();
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from "+departmentName+"_facility_"+facilityId+" where id = "+reservationIdIn+";");
			while(resultSet.next()){
				String reservationId = resultSet.getString(1);
				String date1 = resultSet.getString(2);
				String timeslot = resultSet.getString(3);
				String reserved = resultSet.getString(4);
				String username = resultSet.getString(5);
				Reservation reservation1 = new Reservation(date1, timeslot, reserved,username,reservationId);
				this.reservation = reservation1;
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
		
		
		return this.reservation;
	}
}
