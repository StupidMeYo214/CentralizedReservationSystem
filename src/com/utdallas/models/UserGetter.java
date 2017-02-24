package com.utdallas.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.utdallas.classes.User;

public class UserGetter {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	User user = new User();
	
	public User getUser(String username) {
		
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		

		try{
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM crs.user where userName='"+username+"';");
				while(resultSet.next()){
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
		return user;
		
	}
	
	public void newUser(String name, String username, String password, String email, String level, String address, String department, String departmentId) {
		
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getDBConnector();
		

		try{
				statement = connection.createStatement();
				statement.execute("INSERT INTO `crs`.`user` (`name`, `userName`, `password`, `email`, `level`, `address`, `depart`, `departID`) VALUES ('"+name+"', '"+username+"', '"+password+"', '"+email+"', '"+level+"', '"+address+"', '"+department+"', '"+departmentId+"');");
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
			
	}
	
}
