package com.utdallas.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

	private Connection connection = null;
	
	public Connection getDBConnector(){
		
			try {
			
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","651023");
			
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
				return connection;
			}
}
