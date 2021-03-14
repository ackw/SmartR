package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.models.Employees;
import com.postgresConnection.JdbcConnection;

public class EmployeesDaoImpl {
	public HashMap<String, Employees> retrieveAllEmployees() throws SQLException {
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
					"Error retrieving all employees list. " + e.getMessage());
		}
		return allEmployeesMap;
	}
	
	public boolean addEmployee(Employees employee) throws SQLException {		
		boolean successful = false;
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			PreparedStatement st = con.prepareStatement("INSERT INTO EMPLOYEES (EMPLOYEE_ID, NAME, EMAIL, EMPLOYMENT_TYPE, SALARY) VALUES (?, ?, ?, ?, ?)");
			st.setString(1, employee.getEmployee_id());
			st.setString(2, employee.getName());
			st.setString(3, employee.getEmail());
			st.setString(4, employee.getEmployment_type());
			st.setInt(5, employee.getSalary());
			st.executeUpdate();
			
			st.close();
			stmt.close();
			con.close();
			successful = true;
		} catch (Exception e) {
			System.out.println(
					"Error inserting new employee: " + employee.getEmployee_id() + " " + e.getMessage());
		}
		return successful;
	}
	
	
}
