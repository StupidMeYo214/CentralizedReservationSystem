package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.utdallas.classes.Reservation;
import com.utdallas.classes.ReservedRecord;

public class GetReservation {
	private ArrayList<ReservedRecord> reservations = new ArrayList<>();
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public ArrayList<ReservedRecord> getReserveList(String username){
		//ArrayList<Reservation> reservations = new ArrayList<>();
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM crs.reservations where Username='"+username+"' AND Date >= current_date();");
			while(resultSet.next()){
				String usrname = resultSet.getString(2);
				String department = resultSet.getString(3);
				String facility_id = resultSet.getString(4);
				String facility_name= resultSet.getString(5);
				String date= resultSet.getString(6);
				String timeslot= resultSet.getString(7);
				String reservation_id= resultSet.getString(8);
				ReservedRecord record = new ReservedRecord(usrname, department, facility_id, facility_name, date, timeslot, reservation_id);
				reservations.add(record);
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
	
	public ArrayList<ReservedRecord> getReserveListByDpt(String departmentName, String facilityId){
		//ArrayList<Reservation> reservations = new ArrayList<>();
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM crs.reservations where department='"+departmentName+"' AND facility_id='"+facilityId+"' AND Date >= current_date();");
			while(resultSet.next()){
				String usrname = resultSet.getString(2);
				String department = resultSet.getString(3);
				String facility_id = resultSet.getString(4);
				String facility_name= resultSet.getString(5);
				String date= resultSet.getString(6);
				String timeslot= resultSet.getString(7);
				String reservation_id= resultSet.getString(8);
				ReservedRecord record = new ReservedRecord(usrname, department, facility_id, facility_name, date, timeslot, reservation_id);
				reservations.add(record);
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
