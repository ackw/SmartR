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
		
		String monStart = configObj.getMonStart();
		if (monStart.equals("closed")) {
			request.setAttribute("monStatus", "closed");
		} else {
			request.setAttribute("monStatus", "open");
			request.setAttribute("monStart", configObj.getMonStart());
			request.setAttribute("monEnd", configObj.getMonEnd());
		}
		
		String tuesStart = configObj.getTuesStart();
		if (tuesStart.equals("closed")) {
			request.setAttribute("tuesStart", "closed");
		} else {
			request.setAttribute("tuesStart", "open");
			request.setAttribute("tuesStart", configObj.getTuesStart());
			request.setAttribute("tuesEnd", configObj.getTuesEnd());
		}
		
		String wedStart = configObj.getWedStart();
		if (wedStart.equals("closed")) {
			request.setAttribute("wedStatus", "closed");
		} else {
			request.setAttribute("wedStatus", "open");
			request.setAttribute("wedStart", configObj.getWedStart());
			request.setAttribute("wedEnd", configObj.getWedEnd());
		}
		
		String thursStart = configObj.getThursStart();
		if (thursStart.equals("closed")) {
			request.setAttribute("thursStatus", "closed");
		} else {
			request.setAttribute("thursStatus", "open");
			request.setAttribute("thursStart", configObj.getThursStart());
			request.setAttribute("thursEnd", configObj.getThursEnd());
		}
		
		String friStart = configObj.getFriStart();
		if (friStart.equals("closed")) {
			request.setAttribute("friStatus", "closed");
		} else {
			request.setAttribute("friStatus", "open");
			request.setAttribute("friStart", configObj.getFriStart());
			request.setAttribute("friEnd", configObj.getFriEnd());
		}
		
		String satStart = configObj.getSatStart();
		if (satStart.equals("closed")) {
			request.setAttribute("satStatus", "closed");
		} else {
			request.setAttribute("satStatus", "open");
			request.setAttribute("satStart", configObj.getSatStart());
			request.setAttribute("satEnd", configObj.getSatEnd());
		}
		
		String sunStart = configObj.getSunStart();
		if (sunStart.equals("closed")) {
			request.setAttribute("sunStatus", "closed");
		} else {
			request.setAttribute("sunStatus", "open");
			request.setAttribute("sunStart", configObj.getSunStart());
			request.setAttribute("sunEnd", configObj.getSunEnd());
		}
		
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
		if (gracePeriod == null) {
			errorMsg += "Please input grace period value.";
		} else {
			configObj.setGrace_period(Integer.parseInt(gracePeriod));
		}
		
		String notiEmail = request.getParameter("notiEmail");
		if (notiEmail == null) {
			errorMsg += "Please input notification email address. ";
		} else {
			configObj.setNoti_email(notiEmail);
		}
		
		String notiPW = request.getParameter("notiPW");
		if (notiPW == null) {
			errorMsg += "Please input notification email password. ";
		} else {
			configObj.setNoti_pw(notiPW);
		}
		
		if (errorMsg == "") {			
			try {
				boolean successful =  configDAO.editConfig(configObj);
				
				if (successful == true) {
					Configurations newConfigObj = new Configurations();
					try {
						newConfigObj = configDAO.getConfig();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					request.setAttribute("monStart", newConfigObj.getMonStart());
					request.setAttribute("tuesStart", newConfigObj.getTuesStart());
					request.setAttribute("wedStart", newConfigObj.getWedStart());
					request.setAttribute("thursStart", newConfigObj.getThursStart());
					request.setAttribute("friStart", newConfigObj.getFriStart());
					request.setAttribute("satStart", newConfigObj.getSatStart());
					request.setAttribute("sunStart", newConfigObj.getSunStart());
					request.setAttribute("monEnd", newConfigObj.getMonEnd());
					request.setAttribute("tuesEnd", newConfigObj.getTuesEnd());
					request.setAttribute("wedEnd", newConfigObj.getWedEnd());
					request.setAttribute("thursEnd", newConfigObj.getThursEnd());
					request.setAttribute("friEnd", newConfigObj.getFriEnd());
					request.setAttribute("satEnd", newConfigObj.getSatEnd());
					request.setAttribute("sunEnd", newConfigObj.getSunEnd());
					request.setAttribute("gracePeriod", newConfigObj.getGrace_period());
					request.setAttribute("notiEmail", newConfigObj.getNoti_email());
					request.setAttribute("notiPW", newConfigObj.getNoti_pw());
					request.setAttribute("message", "Successfully updated configurations");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/configurationPage.jsp");
					rd.forward(request, response);
				} 

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("monStart", monStart);
			request.setAttribute("tuesStart", tuesStart);
			request.setAttribute("wedStart", wedStart);
			request.setAttribute("thursStart", thursStart);
			request.setAttribute("friStart", friStart);
			request.setAttribute("satStart", satStart);
			request.setAttribute("sunStart", sunStart);
			request.setAttribute("monEnd", monEnd);
			request.setAttribute("tuesEnd", tuesEnd);
			request.setAttribute("wedEnd", wedEnd);
			request.setAttribute("thursEnd", thursEnd);
			request.setAttribute("friEnd", friEnd);
			request.setAttribute("satEnd", satEnd);
			request.setAttribute("sunEnd", sunEnd);
			request.setAttribute("gracePeriod", gracePeriod);
			request.setAttribute("notiEmail", notiEmail);
			request.setAttribute("notiPW", notiPW);
			request.setAttribute("message2", errorMsg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/configurationPage.jsp");
			rd.forward(request, response);
		}	
	}

}
