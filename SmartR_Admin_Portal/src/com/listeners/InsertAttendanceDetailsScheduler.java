package com.listeners;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dao.AttendanceDaoImpl;
import com.dao.ConfigurationsDaoImpl;
import com.dao.EmployeesDaoImpl;
import com.dao.LeavesDaoImpl;

public class InsertAttendanceDetailsScheduler implements Runnable {
	ConfigurationsDaoImpl configDAO = new ConfigurationsDaoImpl();
	EmployeesDaoImpl employeesDAO = new EmployeesDaoImpl();
	AttendanceDaoImpl attendanceDAO = new AttendanceDaoImpl();
	LeavesDaoImpl leavesDAO = new LeavesDaoImpl();
	
	@Override
	public void run() {
		Calendar currentDate = Calendar.getInstance();
		
		System.out.println("========================================");
		System.out.println("Insert attendance scheduler initialized.");
		System.out.println("Current time: " + currentDate.getTime());
		System.out.println("========================================");
		
		int currentDayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK);
		
		String dayOfWeek = "";
		if (currentDayOfWeek == 1) {
			dayOfWeek = "sunStart";
		} else if (currentDayOfWeek == 2) {
			dayOfWeek = "monStart";
		} else if (currentDayOfWeek == 3) {
			dayOfWeek = "tuesStart";
		} else if (currentDayOfWeek == 4) {
			dayOfWeek = "wedStart";
		} else if (currentDayOfWeek == 5) {
			dayOfWeek = "thursStart";
		} else if (currentDayOfWeek == 6) {
			dayOfWeek = "friStart";
		} else if (currentDayOfWeek == 7) {
			dayOfWeek = "satStart";
		}
		
		String operationStatus = "";
		try {
			operationStatus = configDAO.getOperationStatus(dayOfWeek);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// office will be operating for the day. 
		if (!operationStatus.isEmpty() || !operationStatus.equals("closed")) {
			System.out.println("Office will operate from: " + operationStatus + " hrs");
			System.out.println("Inserting attendance list now..");
			// insert attendance list for today into database
			List<String> employeeIDList = new ArrayList<String>();
			
			try {
				employeeIDList = employeesDAO.retrieveAllEmployeesID();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// Forming today's date 
			String date = "";
			if (currentDate.get(Calendar.MONTH) < Calendar.OCTOBER) {
				date = currentDate.get(Calendar.YEAR) + "-0" + String.valueOf(currentDate.get(Calendar.MONTH) + 1) + "-" + currentDate.get(Calendar.DAY_OF_MONTH);
			} else {
				date = currentDate.get(Calendar.YEAR) + "-" + String.valueOf(currentDate.get(Calendar.MONTH) + 1) + "-" + currentDate.get(Calendar.DAY_OF_MONTH);
			}
			
			for (int i = 0; i < employeeIDList.size(); i++) {
				try {
					int count = leavesDAO.checkLeaves(employeeIDList.get(i), date);
					if (count > 0) {
						//attendanceDAO.addAttendanceWithLeave(employeeIDList.get(i), date);
					} else {
						//attendanceDAO.addAttendance(employeeIDList.get(i), date);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Inserting of attendance list completed.");
			
		} else {
			System.out.println("Office is not open for today. No attendance list is inserted. \n Terminated..");
		}
	}
}
