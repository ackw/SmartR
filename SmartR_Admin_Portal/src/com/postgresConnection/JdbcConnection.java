package com.postgresConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "org.postgresql.Driver"; 
        String dbURL = "jdbc:postgresql://localhost:5432/"; 
        // Database name to access 
        String dbName = "SmartR"; 
        String dbUsername = "postgres"; 
        String dbPassword = "winson123";
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); 
		System.out.println(con);

        return con; 
    } 
}