package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConfigurationsDaoImpl;
import com.models.Configurations;
import com.models.Employees;


@WebServlet("/ConfigurationPageServlet")
public class ConfigurationPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ConfigurationsDaoImpl configDAO = new ConfigurationsDaoImpl();
	
    public ConfigurationPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configurations configObj = new Configurations();
		try {
			configObj = configDAO.getConfig();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("monStart", configObj.getMonStart());
		request.setAttribute("tuesStart", configObj.getTuesStart());
		request.setAttribute("wedStart", configObj.getWedStart());
		request.setAttribute("thursStart", configObj.getThursStart());
		request.setAttribute("friStart", configObj.getFriStart());
		request.setAttribute("satStart", configObj.getSatStart());
		request.setAttribute("sunStart", configObj.getSunStart());
		request.setAttribute("monEnd", configObj.getMonEnd());
		request.setAttribute("tuesEnd", configObj.getTuesEnd());
		request.setAttribute("wedEnd", configObj.getWedEnd());
		request.setAttribute("thursEnd", configObj.getThursEnd());
		request.setAttribute("friEnd", configObj.getFriEnd());
		request.setAttribute("satEnd", configObj.getSatEnd());
		request.setAttribute("sunEnd", configObj.getSunEnd());
		request.setAttribute("gracePeriod", configObj.getGrace_period());
		request.setAttribute("notiEmail", configObj.getNoti_email());
		request.setAttribute("notiPW", configObj.getNoti_pw());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/configurationPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configurations configObj = new Configurations();
		String errorMsg = "";
		
		// retrieving all data and putting into configObj 
		String monStart = request.getParameter("monStart");
		String monEnd = request.getParameter("monEnd");
		String monStatus = request.getParameter("monStatus");
		
		if (monStatus.equals("closed")) {
			configObj.setMonStart("closed");
			configObj.setMonEnd("closed");
		} else {
			if (monStart.isEmpty() || monEnd.isEmpty()) {
				 errorMsg += "Please complete operation time for Monday. ";
			} else {
				configObj.setMonStart(monStart);
				configObj.setMonEnd(monEnd);
			}
		}
		
		String tuesStart = request.getParameter("tuesStart");
		String tuesEnd = request.getParameter("tuesEnd");
		String tuesStatus = request.getParameter("tuesStatus");
		
		if (tuesStatus.equals("closed")) {
			configObj.setTuesStart("closed");
			configObj.setTuesEnd("closed");
		} else {
			if (tuesStart.isEmpty() || tuesEnd.isEmpty()) {
				 errorMsg += "Please complete operation time for Tuesday. ";
			} else {
				configObj.setTuesStart(tuesStart);
				configObj.setTuesEnd(tuesEnd);
			}
		}
		
		String wedStart = request.getParameter("wedStart");
		String wedEnd = request.getParameter("wedEnd");
		String wedStatus = request.getParameter("wedStatus");
		
		if (wedStatus.equals("closed")) {
			configObj.setWedStart("closed");
			configObj.setWedEnd("closed");
		} else {
			if (wedStart.isEmpty() || wedEnd.isEmpty()) {
				 errorMsg += "Please complete operation time for Wednesday. ";
			} else {
				configObj.setWedStart(wedStart);
				configObj.setWedEnd(wedEnd);
			}
		}
		
		String thursStart = request.getParameter("thursStart");
		String thursEnd = request.getParameter("thursEnd");
		String thursStatus = request.getParameter("thursStatus");
		
		if (thursStatus.equals("closed")) {
			configObj.setThursStart("closed");
			configObj.setThursEnd("closed");
		} else {
			if (thursStart.isEmpty() || thursEnd.isEmpty()) {
				 errorMsg += "Please complete operation time for Thursday. ";
			} else {
				configObj.setThursStart(thursStart);
				configObj.setThursEnd(thursEnd);
			}
		}
		
		String friStart = request.getParameter("friStart");
		String friEnd = request.getParameter("friEnd");
		String friStatus = request.getParameter("friStatus");
		
		if (friStatus.equals("closed")) {
			configObj.setFriStart("closed");
			configObj.setFriEnd("closed");
		} else {
			if (friStart.isEmpty() || friEnd.isEmpty()) {
				 errorMsg += "Please complete operation time for Friday. ";
			} else {
				configObj.setFriStart(friStart);
				configObj.setFriEnd(friEnd);
			}
		}
		
		String satStart = request.getParameter("satStart");
		String satEnd = request.getParameter("satEnd");
		String satStatus = request.getParameter("satStatus");
		
		if (satStatus.equals("closed")) {
			configObj.setSatStart("closed");
			configObj.setSatEnd("closed");
		} else {
			if (satStart.isEmpty() || satEnd.isEmpty()) {
				errorMsg += "Please complete operation time for Saturday. ";
			} else {
				configObj.setSatStart(satStart);
				configObj.setSatEnd(satEnd);
			}
		}
		
		String sunStart = request.getParameter("sunStart");
		String sunEnd = request.getParameter("sunEnd");
		String sunStatus = request.getParameter("sunStatus");
		
		if (sunStatus.equals("closed")) {
			configObj.setSunStart("closed");
			configObj.setSunEnd("closed");
		} else {
			if (sunStart.isEmpty() || sunEnd.isEmpty()) {
				errorMsg += "Please complete operation time for Sunday. ";
			} else {
				configObj.setSunStart(sunStart);
				configObj.setSunEnd(sunEnd);
			}
		}
		
		String gracePeriod = request.getParameter("gracePeriod");
		String notiEmail = request.getParameter("emailNoti");
		String notiPW = request.getParameter("notiPW");
		configObj.setGrace_period(gracePeriod);
		configObj.setNoti_email(notiEmail);
		configObj.setNoti_pw(notiPW);
		
	}

}
