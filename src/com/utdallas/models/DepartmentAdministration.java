package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.utdallas.classes.Department;
import com.utdallas.classes.Facility;

public class DepartmentAdministration  {

	private ArrayList<Department> departmentList = new ArrayList<>();
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void createDepartment (String departmentName, String departmentAddress, String contactEmail,String contactPhone, String img){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		
		try {
			statement = connection.createStatement();

			//update department table
			statement.execute("INSERT INTO `crs`.`department` (`departmentName`, `departmentAddress`, `contactEmail`, `contactPhone`, `img`) VALUES ('"+departmentName+"', '"+departmentAddress+"', '"+contactEmail+"', '"+contactPhone+"', '"+img+"');");
			//create facility table
			statement.execute("CREATE TABLE `crs`.`"+departmentName+"_facility` (`facilityID` INT(11) NOT NULL, `FacilityName` VARCHAR(45) NOT NULL,`dpt` VARCHAR(45) NOT NULL, `dptID` INT(11) NOT NULL,`restrictionLevel` VARCHAR(45) NOT NULL DEFAULT '1',`description` TEXT NULL,PRIMARY KEY (`facilityID`));");
			statement.execute("ALTER TABLE `crs`.`"+departmentName+"_facility` CHANGE COLUMN `facilityID` `facilityID` INT(11) NOT NULL AUTO_INCREMENT ;");
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
	
	public void  deleteDepartment(String departmentId, String departmentName) {
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		
		try {
			statement = connection.createStatement();
			
			//delete from department table
			statement.execute("DELETE FROM `crs`.`department` WHERE `departmentID`='"+departmentId+"';");
			
			//delete facilities
				//get faciplity list
			ArrayList<Facility> FacilityList = new ArrayList<>();
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
				//drop availability table
			for ( int i = 0; i < FacilityList.size(); i++){
				Facility temp = FacilityList.get(i);
				String facilityId = temp.getFacilityID();
				statement.execute("DROP TABLE `crs`.`ecss_facility_"+facilityId+"`;");
			}
		
			//delete reservations
			statement.execute("DELETE FROM `crs`.`reservations` WHERE `department`='"+departmentName+"';");
			
			//delete dptName_facility
			statement.execute("DROP TABLE `crs`.`"+departmentName+"_facility`;");

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
	
	public void editDepartment(String departmentId, String departmentAddress, String contactEmail, String contactPhone, String img){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		//update department table
		try {
			statement = connection.createStatement();
			statement.execute("UPDATE `crs`.`department` SET  `departmentAddress`='"+departmentAddress+"', `contactEmail`='"+contactEmail+"', `contactPhone`='"+contactPhone+"', `img`='"+img+"' WHERE `departmentID`='"+departmentId+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
