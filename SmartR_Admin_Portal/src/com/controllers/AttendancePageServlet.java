package com.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AttendanceDaoImpl;
import com.dao.EmployeesDaoImpl;
import com.models.Attendance;
import com.models.Employees;

@WebServlet("/AttendancePageServlet")
public class AttendancePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AttendanceDaoImpl attendanceDAO = new AttendanceDaoImpl();
	EmployeesDaoImpl employeesDAO = new EmployeesDaoImpl();

	public AttendancePageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Attendance> allAttendanceList = new ArrayList<Attendance>();
		HashMap<String, Employees> allEmployeesMap = new HashMap<String, Employees>();

		List<Employees> employeeList = new ArrayList<Employees>();

		try {
			allAttendanceList = attendanceDAO.retrieveAllAttendance();
			allEmployeesMap = employeesDAO.retrieveAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Matching attendance list's employees with default full employees list to
		// retrieve more employees details
		for (int i = 0; i < allAttendanceList.size(); i++) {
			Employees employeeObj = new Employees();
			employeeObj = allEmployeesMap.get(allAttendanceList.get(i).getEmployee_id());
			employeeList.add(employeeObj);
		}

		request.setAttribute("allemployeeList", allEmployeesMap);
		request.setAttribute("allAttendanceList", allAttendanceList);
		request.setAttribute("employeeList", employeeList);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/attendancePage.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Attendance> allAttendanceList = new ArrayList<Attendance>();
		HashMap<String, Employees> allEmployeesMap = new HashMap<String, Employees>();

		List<Employees> employeeList = new ArrayList<Employees>();

		String[] nameList = request.getParameterValues("nameList");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String employmentType = request.getParameter("employmentType");

		try {
			allAttendanceList = attendanceDAO.retrieveFilteredAttendance(nameList, startDate, endDate, employmentType);
			allEmployeesMap = employeesDAO.retrieveAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Matching attendance list's employees with default full employees list to
		// retrieve more employees details
		for (int i = 0; i < allAttendanceList.size(); i++) {
			Employees employeeObj = new Employees();
			employeeObj = allEmployeesMap.get(allAttendanceList.get(i).getEmployee_id());
			employeeList.add(employeeObj);
		}

		request.setAttribute("allemployeeList", allEmployeesMap);
		request.setAttribute("allAttendanceList", allAttendanceList);
		request.setAttribute("employeeList", employeeList);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/attendancePage.jsp");
		rd.forward(request, response);
	}

}
