package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.utdallas.classes.Facility;
import com.utdallas.classes.Reservation;

public class MakeReservation {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	public Boolean makeReservation(String departmentName, String facilityId, String reservationId,String username){
		DBConnector connector = new DBConnector();
		connection = connector.getDBConnector();
		//String tableName = departmentName+"_facility_"+facilityId;
		GetFacility facilityGetter = new GetFacility();
		GetAvailableReservation reservationGetter = new GetAvailableReservation();
		Facility facility = facilityGetter.getFacility(departmentName, facilityId);
		Reservation reservation = reservationGetter.getReservation(departmentName, facilityId, reservationId);
		try {
			statement = connection.createStatement();
			int times = 0;
			String facilityName=facility.getFacilityName();
			String timeSlot=reservation.getTimeslot();
			String date=reservation.getDate();
			resultSet = statement.executeQuery("SELECT count(*) FROM crs.reservations where Username='"+username+"' and Date='"+date+"' and facility_id='"+facilityId+"';");
			while (resultSet.next()) {
				times = resultSet.getInt(1);
			}
			
			if(times >=2 ){
				return true;
			}
			
			//change facility table
			statement.execute("UPDATE `"+departmentName+"_facility_"+facilityId+"` SET `Reserved`='1', `Username`='"+username+"' WHERE `id`='"+reservationId+"';");
			//insert reservation table
			statement.execute("INSERT INTO `crs`.`reservations` (`username`, `department`, `facility_id`, `facility_name`, `date`, `timeslot`, `reservation_id`) VALUES ('"+username+"', '"+departmentName+"', '"+facilityId+"', '"+facilityName+"', '"+date+"', '"+timeSlot+"', '"+reservationId+"');");
			
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
		return false;
	}
	
	public Boolean editReservation(String departmentName, String facilityId, String reservationId,String username){
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
			statement.execute("UPDATE `"+departmentName+"_facility_"+facilityId+"` SET `Username`='"+username+"' WHERE `id`='"+reservationId+"';");
			//update reservation table
			statement.execute("SET SQL_SAFE_UPDATES = 0;");
			statement.execute("UPDATE `crs`.`reservations` SET `username`='"+username+"' WHERE `facility_id`='"+facilityId+"' AND `reservation_id`='"+reservationId+"';");
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
		return false;
	}
	
}
