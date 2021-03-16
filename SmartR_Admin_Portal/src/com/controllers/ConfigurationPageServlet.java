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

import com.dao.ConfigurationDaoImpl;
import com.dao.EmployeesDaoImpl;
import com.models.Attendance;
import com.models.Configuration;
import com.models.Employees;

/**
 * Servlet implementation class ConfigurationPageServlet
 */
@WebServlet("/ConfigurationPageServlet")
public class ConfigurationPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	ConfigurationDaoImpl ConfigDAO = new ConfigurationDaoImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigurationPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Configuration> allConfigList = new ArrayList<Configuration>();

		try {
			allConfigList = ConfigDAO.retrieveAllConfig();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("allConfigList", allConfigList);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/configurationPage.jsp");
		rd.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String errorMsg = "";
        
        String openinghours = request.getParameter("openinghours");
        String closinghours = request.getParameter("closinghours");
        String days = request.getParameter("days");
        String isclosed = request.getParameter("isclosed");
        String graceperiod = request.getParameter("graceperiod");
        String email = request.getParameter("email");
        String password = request.getParameter("password");        
        
        if (openinghours == null || openinghours.isEmpty()) {
            errorMsg += "Start Time cannot be empty. ";
        }
        
        if (closinghours == null || closinghours.isEmpty()) {
            errorMsg += "End Time cannot be empty. ";
        }
        
//        if (CheckBox == null || CheckBox.isEmpty()) {
//            errorMsg += "End Time cannot be empty. ";
//        }
        
        if (days == null || days.isEmpty()) {
            errorMsg += "Select day. ";
        }
        
        if (graceperiod == null || graceperiod.isEmpty()) {
            errorMsg += "Select Grace period. ";
        }
        
        if (email == null || email.isEmpty()) {
            errorMsg += "Email cannot be empty. ";
        }
        
        if (password == null || password.isEmpty()) {
            errorMsg += "Password cannot be empty. ";
        }

        if (errorMsg == "") {
            Configuration config = new Configuration(openinghours, closinghours, days, isclosed, graceperiod, email, password);
            
            try {
                boolean successful =  ConfigDAO.editConfig(config);
            	System.out.println(successful);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("openinghours", openinghours);
            request.setAttribute("closinghours", closinghours);
            request.setAttribute("graceperiod", graceperiod);
            request.setAttribute("isclosed", isclosed);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/configurationPage.jsp");
            rd.forward(request, response);
        }
    }

}



