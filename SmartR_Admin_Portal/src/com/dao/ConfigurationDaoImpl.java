package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.models.Attendance;
import com.models.Configuration;
import com.postgresConnection.JdbcConnection;

public class ConfigurationDaoImpl {
    public List<Configuration> retrieveAllConfig() throws SQLException {
    	List<Configuration> allConfigList = new ArrayList<Configuration>();
        try {
            Connection con = JdbcConnection.initializeDatabase(); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OPERATINGHOURS;");
            while (rs.next()) {
                Configuration config = new Configuration();
                config.setOpening_hours(rs.getString("openinghours"));
                config.setClosing_hours(rs.getString("closinghours"));
                config.setDay(rs.getString("days"));
                config.setIsClosed(rs.getString("isclosed"));
                config.setGrace_period(rs.getString("graceperiod"));
                config.setEmail(rs.getString("email"));
                config.setPassword(rs.getString("password"));
                allConfigList.add(config);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(
                    "Error retrieving all operating hours list. " + e.getMessage());
        }
        return allConfigList;
    }
    
    public boolean editConfig(Configuration config) throws SQLException {        
        boolean successful = false;
        try {
            Connection con = JdbcConnection.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            //PreparedStatement st = con.prepareStatement("UPDATE Operating_hours SET Opening_hour = ?, Closing_hours = ?, Grace_period = ?, password = ?, email= ?, isClosed = ? \n WHERE Days = Monday");            
            PreparedStatement st = con.prepareStatement("UPDATE OPERATINGHOURS SET openinghours = '03:30:00' WHERE days = 'Monday'");            
        	System.out.println("inininininininininin");
            st.setString(1, config.getOpening_hours());
            st.setString(2, config.getClosing_hours()); 
            st.setString(3, config.getGrace_period());
            st.setString(4, config.getPassword());
            st.setString(5, config.getEmail());
            st.setString(6, config.getIsClosed());
            //st.setString(7, config.getDay());
            //not sure if need tosave password
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


