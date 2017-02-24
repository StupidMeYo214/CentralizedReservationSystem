package com.utdallas.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.utdallas.classes.Facility;
import com.utdallas.classes.Reservation;

public class CancelReservation {

	Connection connection = null;
	Statement statement = null;
	
	public void cancel(String departmentName, String facilityId, String reservationId,String username){
		DBConnector connector = new DBConnector();
		connection = connector.getDBConnector();
		//String tableName = departmentName+"_facility_"+facilityId;
		GetFacility facilityGetter = new GetFacility();
		GetAvailableReservation reservationGetter = new GetAvailableReservation();
		Facility facility = facilityGetter.getFacility(departmentName, facilityId);
		Reservation reservation = reservationGetter.getReservation(departmentName, facilityId, reservationId);
		try {
			statement = connection.createStatement();
			
			String facilityName=facility.getFacilityName();
			String timeSlot=reservation.getTimeslot();
			String date=reservation.getDate();
			//change facility table
			statement.execute("UPDATE `"+departmentName+"_facility_"+facilityId+"` SET `Reserved`='0', `Username`=NULL WHERE `id`='"+reservationId+"';");
			//delete record from reservation table
			statement.execute("SET SQL_SAFE_UPDATES = 0;");
			statement.execute("DELETE FROM `crs`.`reservations` WHERE `facility_name`='"+facilityName+"' AND `reservation_id`='"+reservationId+"';");
			statement.execute("SET SQL_SAFE_UPDATES = 1;");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(statement!=null)
				statement.close();
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void cancel(String departmentName, String facilityId, String reservationId){
		DBConnector connector = new DBConnector();
		connection = connector.getDBConnector();
		//String tableName = departmentName+"_facility_"+facilityId;
		GetFacility facilityGetter = new GetFacility();
		GetAvailableReservation reservationGetter = new GetAvailableReservation();
		Facility facility = facilityGetter.getFacility(departmentName, facilityId);
		Reservation reservation = reservationGetter.getReservation(departmentName, facilityId, reservationId);
		try {
			statement = connection.createStatement();
			
			String facilityName=facility.getFacilityName();
			String timeSlot=reservation.getTimeslot();
			String date=reservation.getDate();
			//change facility table
			statement.execute("UPDATE `"+departmentName+"_facility_"+facilityId+"` SET `Reserved`='0', `Username`=NULL WHERE `id`='"+reservationId+"';");
			//delete record from reservation table
			statement.execute("SET SQL_SAFE_UPDATES = 0;");
			statement.execute("DELETE FROM `crs`.`reservations` WHERE `facility_name`='"+facilityName+"' AND `reservation_id`='"+reservationId+"';");
			statement.execute("SET SQL_SAFE_UPDATES = 1;");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(statement!=null)
				statement.close();
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
