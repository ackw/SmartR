package com.dao;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	public List<Employees> retrieveAllEmployeesDetails() throws SQLException {
		List <Employees> allEmployeesList= new ArrayList<Employees>();
		
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
				employeesObj.setBufferedImage(rs.getBinaryStream("image"));
				allEmployeesList.add(employeesObj);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(
					"Error retrieving all employees list. " + e.getMessage());
		}
		return allEmployeesList;
	}
	
	public List<String> retrieveAllEmployeesID() throws SQLException {
		List<String> employeeIDList = new ArrayList<String>();
		
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID FROM EMPLOYEES;");

			while (rs.next()) {
				employeeIDList.add(rs.getString("employee_id"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(
					"Error retrieving all employees ID list. " + e.getMessage());
		}
		return employeeIDList;
	}
	
	public boolean addEmployee(Employees employee, InputStream bufferedImage) throws SQLException {		
		boolean successful = false;
		try {
			Connection con = JdbcConnection.initializeDatabase(); 
			Statement stmt = con.createStatement();

			PreparedStatement st = con.prepareStatement("INSERT INTO EMPLOYEES (EMPLOYEE_ID, NAME, EMAIL, EMPLOYMENT_TYPE, SALARY, IMAGE) VALUES (?, ?, ?, ?, ?, ?)");
			st.setString(1, employee.getEmployee_id());
			st.setString(2, employee.getName());
			st.setString(3, employee.getEmail());
			st.setString(4, employee.getEmployment_type());
			st.setInt(5, employee.getSalary());
			st.setBinaryStream(6, bufferedImage);
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
