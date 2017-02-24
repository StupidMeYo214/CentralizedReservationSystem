package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.utdallas.classes.User;

public class VerificationMachine {
	
	private User user = null;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public User getUser(){
		return this.user;
	} 
	
	public boolean isLegal(String userNameIn, String passwordIn){
		
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		
		boolean result = false;
		String passwordStored = null;
		try{
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from user where userName = '"+ userNameIn +"' limit 1;");
			
				if(resultSet.next())
				{
					passwordStored = resultSet.getString(4);
					
				}
				//verify password
				if(passwordIn != null && passwordStored.equals(passwordIn))
				{
					result = true;
					//the username and password matches, set user
					user = new User();
					user.setId(resultSet.getString(1));
					user.setName(resultSet.getString(2));
					user.setUserName(resultSet.getString(3));
					user.setPassword(resultSet.getString(4));
					user.setEmail(resultSet.getString(5));
					user.setLevel(resultSet.getString(6));
					user.setAddress(resultSet.getString(7));
					user.setDepart(resultSet.getString(8));
					user.setDepartID(resultSet.getString(9));
				}
			}
		catch(Exception e){e.getMessage();}
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
		return result;
	}
	
	public User setUser(String userNameIn, String passwordIn){
		User user = new User();
		
		return user;
	}
	
}
