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
import com.models.Employees;
import com.models.Leaves;
import com.postgresConnection.JdbcConnection;

public class LeavesDaoImpl {
	public List<Leaves> retrieveLeaves (String startDate, String endDate) throws SQLException {
		List<Leaves> allLeavesList = new ArrayList<Leaves>();
		
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM LEAVES WHERE START_DATE BETWEEN '" + startDate + "' AND '" + endDate + "' OR END_DATE BETWEEN '" + startDate + "' AND '" + endDate + "';");

			while (rs.next()) {
				Leaves leavesObj = new Leaves();
				leavesObj.setEmployee_id(rs.getString("employee_id"));
				leavesObj.setStart_date(rs.getString("start_date"));
				leavesObj.setEnd_date(rs.getString("end_date"));
				leavesObj.setReason(rs.getString("reason"));
				allLeavesList.add(leavesObj);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(
					"Error retrieving leaves list. " + e.getMessage());
		}
		return allLeavesList;
	}
	
	public boolean addLeave(Leaves leave) throws SQLException {		
		boolean successful = false;
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			PreparedStatement st = con.prepareStatement("INSERT INTO LEAVES (EMPLOYEE_ID, START_DATE, END_DATE, REASON) VALUES (?, ?, ?, ?)");
			st.setString(1, leave.getEmployee_id());
			st.setString(2, leave.getStart_date());
			st.setString(3, leave.getEnd_date());
			st.setString(4, leave.getReason());
			st.executeUpdate();
			
			st.close();
			stmt.close();
			con.close();
			successful = true;
		} catch (Exception e) {
			System.out.println(
					"Error inserting new leave: " + leave.getEmployee_id() + " " + e.getMessage());
		}
		return successful;
	}
}
