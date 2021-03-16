package com.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeesDaoImpl;
import com.dao.LeavesDaoImpl;
import com.models.Employees;
import com.models.Leaves;

@WebServlet("/LeavesPageServlet")
public class LeavesPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LeavesDaoImpl leavesDAO = new LeavesDaoImpl();
	EmployeesDaoImpl employeesDAO = new EmployeesDaoImpl();

	public LeavesPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<List<String>> calendarList = new ArrayList<List<String>>();
		HashMap<String, List<Leaves>> leavesRecord = new HashMap<String, List<Leaves>>();
		HashMap<String, Employees> allEmployeesMap = new HashMap<String, Employees>();

		Calendar currentDate = Calendar.getInstance();
		int currentYear = currentDate.get(Calendar.YEAR);
		int currentMonth = currentDate.get(Calendar.MONTH) + 1;

		String firstDay = "";
		String lastDay = "";
		if (currentDate.get(Calendar.MONTH) < Calendar.OCTOBER) {
			firstDay = currentYear + "-0" + currentMonth + "-01";
			currentDate.set(Calendar.DAY_OF_MONTH, currentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
			lastDay = currentYear + "-0" + currentMonth + "-" + currentDate.get(Calendar.DAY_OF_MONTH);
		} else {
			firstDay = currentYear + "-" + currentMonth + "-01";
			currentDate.set(Calendar.DAY_OF_MONTH, currentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
			lastDay = currentYear + "-" + currentMonth + "-" + currentDate.get(Calendar.DAY_OF_MONTH);
		}

		String date = getCurrentDate();
		calendarList = getCalendarDetails(currentMonth, currentYear);

		leavesRecord = compileAllLeavesForSelectedMonth(firstDay, lastDay, currentMonth);
		allEmployeesMap = getAllEmployeeDetails();

		request.setAttribute("allEmployeeMap", allEmployeesMap);
		request.setAttribute("leavesRecord", leavesRecord);
		request.setAttribute("calendarList", calendarList);
		request.setAttribute("date", date);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/leavesPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<List<String>> calendarList = new ArrayList<List<String>>();
		HashMap<String, List<Leaves>> leavesRecord = new HashMap<String, List<Leaves>>();
		HashMap<String, Employees> allEmployeesMap = new HashMap<String, Employees>();

		// Generating calendar data for selected Month-Year
		String selectedDate = request.getParameter("date");

			System.out.println(selectedDate);
			int selectedYear = Integer.parseInt(selectedDate.split("-")[0]);
			int selectedMonth = Integer.parseInt(selectedDate.split("-")[1]) - 1;
			int month = selectedMonth + 1;

			Calendar selectedPeriod = Calendar.getInstance();
			selectedPeriod.set(Calendar.MONTH, selectedMonth);
			selectedPeriod.set(Calendar.YEAR, selectedYear);

			String firstDay = "";
			String lastDay = "";
			if (selectedPeriod.get(Calendar.MONTH) < Calendar.OCTOBER) {
				firstDay = selectedYear + "-0" + month + "-01";
				selectedPeriod.set(Calendar.DAY_OF_MONTH, selectedPeriod.getActualMaximum(Calendar.DAY_OF_MONTH));
				lastDay = selectedYear + "-0" + month + "-" + selectedPeriod.get(Calendar.DAY_OF_MONTH);
			} else {
				firstDay = selectedPeriod + "-" + selectedPeriod + "-01";
				selectedPeriod.set(Calendar.DAY_OF_MONTH, selectedPeriod.getActualMaximum(Calendar.DAY_OF_MONTH));
				lastDay = selectedYear + "-" + month + "-" + selectedPeriod.get(Calendar.DAY_OF_MONTH);
			}

			calendarList = getCalendarDetails(month, selectedYear);

			leavesRecord = compileAllLeavesForSelectedMonth(firstDay, lastDay, month);
			allEmployeesMap = getAllEmployeeDetails();

			request.setAttribute("allEmployeeMap", allEmployeesMap);
			request.setAttribute("leavesRecord", leavesRecord);
			request.setAttribute("calendarList", calendarList);
			request.setAttribute("date", selectedDate);

			// Validation for leave application form
			String errorMsg = "";

			String nameList = request.getParameter("nameList");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String reason = request.getParameter("reason");

			if (nameList == null || nameList.isEmpty()) {
				errorMsg += "Employee ID cannot be empty. ";
			}

			if (startDate == null || startDate.isEmpty()) {
				errorMsg += "Start date cannot be empty. ";
			}

			if (endDate == null || endDate.isEmpty()) {
				errorMsg += "Start date cannot be empty. ";
			}

			if (reason == null || reason.isEmpty()) {
				errorMsg += "Start date cannot be empty. ";
			}

			if (errorMsg == "") {
				String employee_id = nameList.split("-")[0];

				Leaves leaveObj = new Leaves(employee_id, startDate, endDate, reason);
				try {
					boolean successful = leavesDAO.addLeave(leaveObj);

					if (successful == true) {
						request.setAttribute("message", "Successfully added leave for " + nameList);
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/addEDetailsPage.jsp");
						rd.forward(request, response);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("nameList", nameList);
				request.setAttribute("startDate", startDate);
				request.setAttribute("endDate", endDate);
				request.setAttribute("reason", reason);
				request.setAttribute("message2", errorMsg);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/leavesPage.jsp");
				rd.forward(request, response);
			}
		}
	

	// to generate the calendar to display on .jsp page
	private List<List<String>> getCalendarDetails(int month, int year) {
		List<List<String>> calendarList = new ArrayList<List<String>>();

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_MONTH, 1); // Set the day of month to 1
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // get day of week for 1st day of month
		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		List<String> calendarWeekList = new ArrayList<String>();

		// print initial spaces
		String initialSpace = "";
		for (int i = 0; i < dayOfWeek - 2; i++) { // -2 as we want the display to be MON to SUN instead of SUN to SAT
			calendarWeekList.add(initialSpace);
		}

		// print the days of the month starting from 1
		for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) { // run loop for number of days in month

			for (int j = ((i == 0) ? dayOfWeek - 2 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) { // run loop each
																										// week
				calendarWeekList.add(String.valueOf(dayOfMonth));
				dayOfMonth++;
				
				// add space for remaining days of the week
				if (dayOfMonth > daysInMonth) {
					calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
					int daysLeft = 7 - calendar.get(Calendar.DAY_OF_WEEK) + 2; // if other days
					if (calendar.get(Calendar.DAY_OF_WEEK) == 2) { // if sunday
						daysLeft = 0;
					}
					if (calendar.get(Calendar.DAY_OF_WEEK) == 1) { // if saturday
						daysLeft = 1;
					}
					for (int k = 0; k < daysLeft; k++) {
						calendarWeekList.add(initialSpace);
					}
				}
			}
			List<String> copyCalendarWeekList = new ArrayList<String>();
			copyCalendarWeekList.addAll(calendarWeekList);
			calendarList.add(copyCalendarWeekList);
			calendarWeekList.clear();
		}
		return calendarList;
	}

	// current date in mm-yyyy format
	private String getCurrentDate() {
		String currentDate = "";
		Calendar calendar = Calendar.getInstance();

		if (calendar.get(Calendar.MONTH) < Calendar.OCTOBER) {
			currentDate = calendar.get(Calendar.YEAR) + "-0" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
		} else {
			currentDate = calendar.get(Calendar.YEAR) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
		}

		return currentDate;
	}

	// adding leaves to each specific day of the month
	private HashMap<String, List<Leaves>> compileAllLeavesForSelectedMonth(String firstDay, String lastDay, int month) {
		HashMap<String, List<Leaves>> leavesRecordMap = new HashMap<String, List<Leaves>>();
		List<Leaves> allLeavesList = new ArrayList<Leaves>();

		try {
			allLeavesList = leavesDAO.retrieveLeaves(firstDay, lastDay);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Calendar selectedDate = Calendar.getInstance();
		selectedDate.set(Calendar.MONTH, month - 1);
		int selectedDateMonth = selectedDate.get(Calendar.MONTH);
		for (int i = 0; i < allLeavesList.size(); i++) {
			// setting start date
			Calendar startDate = Calendar.getInstance();
			int startDateYear = Integer.parseInt(allLeavesList.get(i).getStart_date().split("-")[0]);
			int startDateMonth = Integer.parseInt(allLeavesList.get(i).getStart_date().split("-")[1]) - 1;
			int startDateDay = Integer.parseInt(allLeavesList.get(i).getStart_date().split("-")[2]);
			startDate.set(Calendar.YEAR, startDateYear);
			startDate.set(Calendar.MONTH, startDateMonth);
			startDate.set(Calendar.DAY_OF_MONTH, startDateDay);

			// setting end date
			Calendar endDate = Calendar.getInstance();
			int endDateYear = Integer.parseInt(allLeavesList.get(i).getEnd_date().split("-")[0]);
			int endDateMonth = Integer.parseInt(allLeavesList.get(i).getEnd_date().split("-")[1]) - 1;
			int endDateDay = Integer.parseInt(allLeavesList.get(i).getEnd_date().split("-")[2]);
			endDate.set(Calendar.YEAR, endDateYear);
			endDate.set(Calendar.MONTH, endDateMonth);
			endDate.set(Calendar.DAY_OF_MONTH, endDateDay);

			// if start date is previous month, set start date to this month first day
			if (startDateMonth != selectedDateMonth) {
				startDate.set(Calendar.MONTH, selectedDateMonth);
				startDate.set(Calendar.DAY_OF_MONTH, 1);
			}

			// if end date is next month, set end date to this month last day
			if (endDateMonth != selectedDateMonth) {
				endDate.set(Calendar.MONTH, selectedDateMonth);
				endDate.set(Calendar.DAY_OF_MONTH, endDate.getActualMaximum(Calendar.DAY_OF_MONTH));
			}

			// count how many days in between start date and end date
			// starting from start date, increment to end date, add leaves details to the
			// days
			int startDay = startDate.get(Calendar.DAY_OF_MONTH);
			int endDay = endDate.get(Calendar.DAY_OF_MONTH);
			while (startDay <= endDay) {
				if (leavesRecordMap.containsKey(String.valueOf(startDay))) {
					List<Leaves> leavesList = leavesRecordMap.get(String.valueOf(startDay));
					leavesList.add(allLeavesList.get(i));
					leavesRecordMap.replace(String.valueOf(startDay), leavesList);
				} else {
					List<Leaves> leavesList = new ArrayList<Leaves>();
					leavesList.add(allLeavesList.get(i));
					leavesRecordMap.put(String.valueOf(startDay), leavesList);
				}
				startDay++;
			}
		}
		return leavesRecordMap;
	}

	// get all employees details
	private HashMap<String, Employees> getAllEmployeeDetails() {
		HashMap<String, Employees> allEmployeesMap = new HashMap<String, Employees>();

		try {
			allEmployeesMap = employeesDAO.retrieveAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allEmployeesMap;
	}
}
