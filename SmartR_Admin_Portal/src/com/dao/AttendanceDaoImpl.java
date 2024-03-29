package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.models.Attendance;
import com.models.Employees;
import com.postgresConnection.JdbcConnection;

public class AttendanceDaoImpl {
	public List<Attendance> retrieveAllAttendance() throws SQLException {
		List<Attendance> allAttendanceList = new ArrayList<Attendance>();
		
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM ATTENDANCE;");

			while (rs.next()) {
				Attendance attendanceObj = new Attendance();
				attendanceObj.setEmployee_id(rs.getString("employee_id"));
				attendanceObj.setTime_check_in(rs.getString("time_check_in"));
				attendanceObj.setTime_check_out(rs.getString("time_check_out"));
				attendanceObj.setDate(rs.getString("date"));
				attendanceObj.setIs_late(rs.getInt("is_late"));
				allAttendanceList.add(attendanceObj);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(
					"Error retrieving all attendance list. " + e.getMessage());
		}
		return allAttendanceList;
	}
	
	public List<Attendance> retrieveFilteredAttendance(String[] nameList, String startDate, String endDate, String employmentType) throws SQLException {
		List<Attendance> allAttendanceList = new ArrayList<Attendance>();
		String query = "SELECT * FROM ATTENDANCE ";
		String condition = "WHERE";
		
		if (nameList != null) {
			query += condition + " EMPLOYEE_ID IN (SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE NAME IN (";
			condition = "AND";
			for (int i = 0; i < nameList.length; i++) {
				if (i == nameList.length-1) {
					query += "'" + nameList[i];
				} else {
					query += "'" + nameList[i] + "', ";
				}
			}
			query += "')) ";
		}
		
		if (!startDate.isEmpty()) {
			query += condition + " DATE >= '" + startDate + "'";
			condition = "AND";
		} 
		
		if (!endDate.isEmpty()) {
			query += condition + " DATE <= '" + endDate + "'";
			condition = "AND";
		}
		
		if (employmentType != null) {
			query += condition + " EMPLOYEE_ID IN (SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE EMPLOYMENT_TYPE = '" + employmentType + "') ";
		}
		
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Attendance attendanceObj = new Attendance();
				attendanceObj.setEmployee_id(rs.getString("employee_id"));
				attendanceObj.setTime_check_in(rs.getString("time_check_in"));
				attendanceObj.setTime_check_out(rs.getString("time_check_out"));
				attendanceObj.setDate(rs.getString("date"));
				attendanceObj.setIs_late(rs.getInt("is_late"));
				allAttendanceList.add(attendanceObj);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(
					"Error retrieving all attendance list. " + e.getMessage());
		}
		return allAttendanceList;
	}
	
	public boolean addAttendance(String employee_id, String date) throws SQLException {		
		boolean successful = false;
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			PreparedStatement st = con.prepareStatement("INSERT INTO ATTENDANCE (EMPLOYEE_ID, DATE) VALUES (?, ?)");
			st.setString(1, employee_id);
			st.setString(2, date);
			st.executeUpdate();
			
			st.close();
			stmt.close();
			con.close();
			successful = true;
		} catch (Exception e) {
			System.out.println(
					"Error inserting new attendance for: " + employee_id + " " + e.getMessage());
		}
		return successful;
	}
	
	public boolean addAttendanceWithLeave(String employee_id, String date) throws SQLException {		
		boolean successful = false;
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			PreparedStatement st = con.prepareStatement("INSERT INTO ATTENDANCE (EMPLOYEE_ID, DATE, TIME_CHECK_IN, TIME_CHECK_OUT) VALUES (?, ?, ?, ?)");
			st.setString(1, employee_id);
			st.setString(2, date);
			st.setString(3, "Leave");
			st.setString(4, "Leave");
			st.executeUpdate();
			
			st.close();
			stmt.close();
			con.close();
			successful = true;
		} catch (Exception e) {
			System.out.println(
					"Error inserting new attendance for: " + employee_id + " " + e.getMessage());
		}
		return successful;
	}
}
