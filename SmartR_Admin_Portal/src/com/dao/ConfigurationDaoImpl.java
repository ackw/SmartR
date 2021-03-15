package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.models.Configuration;
import com.postgresConnection.JdbcConnection;

public class ConfigurationDaoImpl {
    public HashMap<String, Configuration> retrieveAllConfig() throws SQLException {
        HashMap<String, Configuration> allConfigMap = new HashMap<String, Configuration>();
        
        try {
            Connection con = JdbcConnection.initializeDatabase(); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CONFIGURATION;");
			System.out.println(rs);


            while (rs.next()) {
                Configuration config = new Configuration();
                config.setOpening_hours(rs.getString("StartTime"));
                config.setClosing_hours(rs.getString("EndTime"));
                config.setDay(rs.getString("selectDay"));
                config.setIsClosed(rs.getString("CheckBox"));
                config.setGrace_period(rs.getString("grace_period"));
                config.setEmail(rs.getString("email"));
                config.setPassword(rs.getString("password"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(
                    "Error retrieving all employees list. " + e.getMessage());
        }
        return allConfigMap;
    }
    
    public boolean editConfig(Configuration config) throws SQLException {        
        boolean successful = false;
        try {
            Connection con = JdbcConnection.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            PreparedStatement st = con.prepareStatement("UPDATE CONFIGURATIONS SET Opening_hour = ?, Closing_hours = ?, Grace_period = ?, email= ?, isClosed = ? \n WHERE DAY = ?");            
            
            st.setString(1, config.getOpening_hours());
            st.setString(2, config.getClosing_hours()); 
            st.setString(3, config.getGrace_period());
            st.setString(4, config.getEmail());
            st.setString(5, config.getIsClosed());
            st.setString(6, config.getDay());
            //not sure if need tosave password
            //st.setString(7, config.getPassword());
            st.executeUpdate();
            st.close();
            stmt.close();
            con.close();
            successful = true;
        } catch (Exception e) {
            System.out.println(
                    "Error inserting updating configurations: " + e.getMessage());
        }
        return successful;
    }
    
    
}


