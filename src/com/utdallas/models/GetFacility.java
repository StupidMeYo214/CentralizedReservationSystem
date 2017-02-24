package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.utdallas.classes.Facility;

public class GetFacility {

	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public Facility getFacility (String departmentName, String facilityID){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		Facility temp = new Facility();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from "+departmentName+"_facility where facilityID = '"+facilityID+"';");
			
			
			while(resultSet.next()){
				
				String facilityId = resultSet.getString(1);
				String facilityName = resultSet.getString(2);
				String dpt = resultSet.getString(3);
				String dptId = resultSet.getString(4);
				String restrictionLevel = resultSet.getString(5);
				String description = resultSet.getString(6);
				temp.setFacility(facilityName, facilityId, dpt, dptId, restrictionLevel,description);
				
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
		
		return temp;

	}

	public Facility createFacility (String facilityName, String dpt, String dptId, String description){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		Facility temp = new Facility();
		String facilityId = null;
		try {
			statement = connection.createStatement();
			//insert new in dpt_facility table
			statement.execute("INSERT INTO `crs`.`"+dpt+"_facility` (`FacilityName`, `dpt`, `dptID`, `restrictionLevel`, `description`) VALUES ('"+facilityName+"', '"+dpt+"', '"+dptId+"', '1', '"+description+"');");
			//get new facilityId
			resultSet = statement.executeQuery("SELECT facilityID FROM crs."+dpt+"_facility where FacilityName='"+facilityName+"';");
			while(resultSet.next()){
				facilityId = resultSet.getString(1);
			}
			//create new table dpt_facility_fId
			statement.execute("CREATE TABLE `"+dpt+"_facility_"+facilityId+"` (`id` int(11) NOT NULL AUTO_INCREMENT,`Date` date NOT NULL,`Timeslot` char(11) NOT NULL,`Reserved` tinyint(4) NOT NULL,`Username` varchar(45) DEFAULT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
			//initialize timeslots
			for (int i = 0; i < 7; i++){
				String date = GetDateString.getDateString(i);
				
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','07:00-08:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','08:00-09:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','09:00-10:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','10:00-11:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','11:00-12:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','12:00-13:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','13:00-14:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','14:00-15:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','15:00-16:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','16:00-17:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','17:00-18:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','18:00-19:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','19:00-20:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','20:00-21:00',0,null);");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) values('"+date+"','21:00-22:00',0,null);");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
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
		
		return temp;

	}

	public ArrayList<Facility> getFacilityList (String departmentName){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		ArrayList<Facility> FacilityList = new ArrayList<>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from "+departmentName+"_facility;");
			
			while(resultSet.next()){
				Facility temp = new Facility();
				String facilityId = resultSet.getString(1);
				String facilityName = resultSet.getString(2);
				String dpt = resultSet.getString(3);
				String dptId = resultSet.getString(4);
				String restrictionLevel = resultSet.getString(5);
				String description = resultSet.getString(6);
				temp.setFacility(facilityName, facilityId, dpt, dptId, restrictionLevel,description);
				FacilityList.add(temp);
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

		
		return FacilityList;
	}

	public void removeFacility (String dpt, String facilityId){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		
		try {
			statement = connection.createStatement();
			//drop availability table
			statement.execute("DROP TABLE `crs`.`"+dpt+"_facility_"+facilityId+"`;");
			//update department record
			statement.execute("DELETE FROM `crs`.`"+dpt+"_facility` WHERE `facilityID`='"+facilityId+"';");
			//remove related reservations
			statement.execute("SET SQL_SAFE_UPDATES = 0;");
			statement.execute("DELETE FROM `crs`.`reservations` WHERE department='"+dpt+"' AND facility_id='"+facilityId+"';");
			statement.execute("SET SQL_SAFE_UPDATES = 1;");
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
	}

	public void editFacility (String dpt, String facilityId, String newName, String newDescription){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		
		try {
			statement = connection.createStatement();
			//update department record
			statement.execute("UPDATE `crs`.`"+dpt+"_facility` SET `FacilityName`='"+newName+"', `description`='"+newDescription+"' WHERE `facilityID`='"+facilityId+"';");
			//update reservations
			statement.execute("SET SQL_SAFE_UPDATES = 0;");
			statement.execute("UPDATE `crs`.`reservations` SET `facility_name`='"+newName+"' WHERE department='"+dpt+"' AND facility_id='"+facilityId+"';");
			statement.execute("SET SQL_SAFE_UPDATES = 1;");
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
	}
	
	public void updateAvailability (String dpt, String facilityId){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		
		try {
			statement = connection.createStatement();
			for (int i = 0; i < 7; i++){
				String date = GetDateString.getDateString(i);

				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','07:00-08:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='07:00-08:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','08:00-09:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='08:00-09:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','09:00-10:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='09:00-10:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','10:00-11:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='10:00-11:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','11:00-12:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='11:00-12:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','12:00-13:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='12:00-13:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','13:00-14:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='13:00-14:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','14:00-15:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='14:00-15:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','15:00-16:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='15:00-16:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','16:00-17:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='16:00-17:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','17:00-18:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='17:00-18:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','18:00-19:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='18:00-19:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','19:00-20:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='19:00-20:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','20:00-21:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='20:00-21:00')LIMIT 1;");
				statement.execute("insert into "+dpt+"_facility_"+facilityId+" (`Date`, `Timeslot`, `Reserved`, `Username`) SELECT * FROM (SELECT '"+date+"','21:00-22:00',0,null) AS tmp WHERE NOT EXISTS (SELECT `Date`, `Timeslot` FROM "+dpt+"_facility_"+facilityId+" where `Date`= '"+date+"' AND `Timeslot`='21:00-22:00')LIMIT 1;");
				
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
	}

}
