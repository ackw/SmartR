package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConfigurationDaoImpl;
import com.dao.EmployeesDaoImpl;
import com.models.Configuration;

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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/configurationPage.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String errorMsg = "";
        
        String StartTime = request.getParameter("StartTime");
        String EndTime = request.getParameter("EndTime");
        String selectDay = request.getParameter("selectDay");
        String isClosed = request.getParameter("CheckBox");
        String grace_period = request.getParameter("grace_period");
        String email = request.getParameter("email");
        String password = request.getParameter("password");        
        
        if (StartTime == null || StartTime.isEmpty()) {
            errorMsg += "Start Time cannot be empty. ";
        }
        
        if (EndTime == null || EndTime.isEmpty()) {
            errorMsg += "End Time cannot be empty. ";
        }
        
//        if (CheckBox == null || CheckBox.isEmpty()) {
//            errorMsg += "End Time cannot be empty. ";
//        }
        
        if (selectDay == null || selectDay.isEmpty()) {
            errorMsg += "Select day. ";
        }
        
        if (grace_period == null || grace_period.isEmpty()) {
            errorMsg += "Select Grace period. ";
        }
        
        if (email == null || email.isEmpty()) {
            errorMsg += "Email cannot be empty. ";
        }
        
        if (password == null || password.isEmpty()) {
            errorMsg += "Password cannot be empty. ";
        }

        if (errorMsg == "") {
            Configuration config = new Configuration(StartTime, EndTime, selectDay, isClosed, grace_period, email, password);
            
            try {
                boolean successful =  ConfigDAO.editConfig(config);
                
                if (successful == true) {
                    request.setAttribute("message", "Successfully edited!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/configurationPage.jsp");
                    rd.forward(request, response);
                } 

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("Grace_period", grace_period);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/configurationPage.jsp");
            rd.forward(request, response);
        }
    }

}



