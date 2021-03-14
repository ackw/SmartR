package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.models.Employees;
import com.postgresConnection.JdbcConnection;

public class LeavesDaoImpl {
	public HashMap<String, Employees> retrieveLeaves(String startDate, String endDate) throws SQLException {
		HashMap<String, Employees> allEmployeesMap = new HashMap<String, Employees>();
		
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES;");

			while (rs.next()) {
				Employees employeesObj = new Employees();
				employeesObj.setEmployee_id(rs.getString("employee_id"));
				employeesObj.setName(rs.getString("name"));
				employeesObj.setEmployment_type(rs.getString("employment_type"));
				employeesObj.setEmail(rs.getString("email"));
				employeesObj.setSalary(rs.getInt("salary"));
				allEmployeesMap.put(rs.getString("employee_id"), employeesObj);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(
					"Error retrieving all attendance list. " + e.getMessage());
		}
		return allEmployeesMap;
	}
}
