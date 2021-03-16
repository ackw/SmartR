package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.models.Configurations;
import com.postgresConnection.JdbcConnection;

public class ConfigurationsDaoImpl {
	public Configurations getConfig() throws SQLException {
		Configurations configObj = new Configurations();
		
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM CONFIGURATIONS;");

			while (rs.next()) {
				configObj.setMonStart(rs.getString("monStart"));
				configObj.setTuesStart(rs.getString("tueStart"));
				configObj.setWedStart(rs.getString("wedStart"));
				configObj.setThursStart(rs.getString("thursStart"));
				configObj.setFriStart(rs.getString("friStart"));
				configObj.setSatStart(rs.getString("satStart"));
				configObj.setSunStart(rs.getString("sunStart"));
				configObj.setMonEnd(rs.getString("monEnd"));
				configObj.setTuesEnd(rs.getString("tueEnd"));
				configObj.setWedEnd(rs.getString("wedEnd"));
				configObj.setThursEnd(rs.getString("thursEnd"));
				configObj.setFriEnd(rs.getString("wedEnd"));
				configObj.setSatEnd(rs.getString("thursEnd"));
				configObj.setSunEnd(rs.getString("friEnd"));
				configObj.setGrace_period(rs.getString("grace_period"));
				configObj.setNoti_email(rs.getString("noti_email"));
				configObj.setNoti_pw(rs.getString("noti_pw"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(
					"Error retrieving configurations. " + e.getMessage());
		}
		return configObj;
	}
	
	 public boolean editConfig(Configurations config) throws SQLException {        
	        boolean successful = false;
	        try {
	            Connection con = JdbcConnection.initializeDatabase(); 
	            Statement stmt = con.createStatement();
	            
	            PreparedStatement st = con.prepareStatement("UPDATE TOP (1) CONFIGURATIONS SET monStart = ?, tuesStart = ?, wedStart = ?, thursStart = ?, friStart = ?, satStart = ?, sunStart = ?, monEnd = ?, tuesEnd = ?, wedEnd = ?, thursEnd = ?, friEnd = ?, satEnd = ?, sunEnd = ?, grace_period = ?, noti_email = ?, noti_pw = ?"); 
           
	            st.setString(1, config.getMonStart());
	            st.setString(2, config.getTuesStart());
	            st.setString(3, config.getWedStart());
	            st.setString(4, config.getThursStart());
	            st.setString(5, config.getFriStart());
	            st.setString(6, config.getSatStart());
	            st.setString(7, config.getSunStart());
	            st.setString(8, config.getMonEnd());
	            st.setString(9, config.getTuesEnd());
	            st.setString(10, config.getWedEnd());
	            st.setString(11, config.getThursEnd());
	            st.setString(12, config.getFriEnd());
	            st.setString(13, config.getSatEnd());
	            st.setString(14, config.getSunEnd());
	            st.setString(15, config.getGrace_period());
	            st.setString(16, config.getNoti_email());
	            st.setString(17, config.getNoti_pw());
	            st.executeUpdate();
	            
	            st.close();
	            stmt.close();
	            con.close();
	            successful = true;
	        } catch (Exception e) {
	            System.out.println(
	                    "Error updating configurations: " + e.getMessage());
	        }
	        return successful;
	    }
}
