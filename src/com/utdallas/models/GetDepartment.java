package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.utdallas.classes.Department;


public class GetDepartment {

	private ArrayList<Department> departmentList = new ArrayList<>();
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public ArrayList<Department> getDepartmentList (){
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from department");
			
			while(resultSet.next()){
				Department temp = new Department();
				String departmentName = resultSet.getString(1);
				String departmentID = resultSet.getString(2);
				String departmentAddress = resultSet.getString(3);
				String contactEmail = resultSet.getString(4);
				String contactPhone = resultSet.getString(5);
				String img = resultSet.getString(6);
				temp.setDepartment(departmentName, departmentID, departmentAddress, contactEmail, contactPhone, img);
				departmentList.add(temp);
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
		
		
		return this.departmentList;
	}
}
