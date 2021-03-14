package com.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeavesPageServlet")
public class LeavesPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LeavesPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<List<String>> calendarList = new ArrayList<List<String>>();
		calendarList = getCalendarDetails(3, 2021);
		String date = getCurrentDate();
		
		request.setAttribute("calendarList", calendarList);
		request.setAttribute("date", date);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/leavesPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	// to generate the calendar to display on .jsp page
	private List<List<String>> getCalendarDetails (int month, int year) {
		List<List<String>> calendarList = new ArrayList<List<String>>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_MONTH, 1); //Set the day of month to 1
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); //get day of week for 1st of month
		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//print month name and year
		System.out.println(new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));

		List<String> calendarWeekList = new ArrayList<String>();
		
		//print initial spaces
		String initialSpace = "";
		for (int i = 0; i < dayOfWeek - 2; i++) { // -2 as we want the display to be MON to SUN instead of SUN to SAT
			calendarWeekList.add(initialSpace);
		}

		//print the days of the month starting from 1
		for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) { // run loop for number of days in month
			
			for (int j = ((i == 0) ? dayOfWeek-2 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) { // run loop each week
				calendarWeekList.add(String.valueOf(dayOfMonth));
		        dayOfMonth++;
		        if (dayOfMonth > daysInMonth) {
		        	calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		        	int daysLeft = 7 - calendar.get(Calendar.DAY_OF_WEEK) + 2;
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
	
	private String getCurrentDate () {
		String currentDate = "";
		Calendar calendar = Calendar.getInstance();

		if (calendar.get(Calendar.MONTH) < Calendar.OCTOBER) {
			currentDate = calendar.get(Calendar.YEAR) + "-0" + String.valueOf(calendar.get(Calendar.MONTH)+1);
		} else {
			currentDate = calendar.get(Calendar.YEAR) + "-" + String.valueOf(calendar.get(Calendar.MONTH)+1);
		}
		
		return currentDate;
	}

}
