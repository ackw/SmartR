package com.dao;

import com.models.Users;
import com.postgresConnection.JdbcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDaoImpl {

	// Retrieving login details of a entered username, to check if such account
	// exists and is valid for access
	public boolean login(String username, String password) throws SQLException {
		boolean successful = false;
		
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();
			System.out.println("Hi1");
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");
			System.out.println("Hi2");
			if(rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));

			if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
				successful = true;
			} else {
				successful = false;
			}
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(
					"Error retrieving login details from database for username: " + username + ". " + e.getMessage());
		}
		return successful;
	}
}
