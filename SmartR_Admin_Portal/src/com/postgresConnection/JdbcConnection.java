package com.postgresConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "org.postgresql.Driver"; 
        String dbURL = "jdbc:postgresql://127.0.0.1:5432/"; 
        // Database name to access 
        String dbName = "SmartR"; 
        String dbUsername = "postgres"; 
        String dbPassword = "0000"; 
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); 
        return con; 
    } 
}