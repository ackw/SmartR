package com.controllers;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeesDaoImpl;
import com.models.Employees;


@WebServlet("/AddEDetailsPageServlet")
public class AddEDetailsPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	EmployeesDaoImpl employeesDAO = new EmployeesDaoImpl();
	
    public AddEDetailsPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/addEDetailsPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errorMsg = "";
		
		String employeeID = request.getParameter("employeeID");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String employmentType = request.getParameter("employmentType");
		String salary = request.getParameter("salary");
		String photoURL = request.getParameter("photoURL");

		if (employeeID == null || employeeID.isEmpty()) {
			errorMsg += "Employee ID cannot be empty. ";
		}
		
		if (name == null || employeeID.isEmpty()) {
			errorMsg += "Name cannot be empty. ";
		}
		
		if (employmentType == null) {
			errorMsg += "Select Employment Type. ";
		}
		
		try {
		    Integer.parseInt(salary);
		} catch (NumberFormatException e) {
			errorMsg += "Enter numbers only for salary. ";
		}

		if (errorMsg == "") {
			Employees employeeObj = new Employees(employeeID, name, email, employmentType, Integer.parseInt(salary));
			
			try {
				boolean successful =  employeesDAO.addEmployee(employeeObj);
				
				if (successful == true) {
					request.setAttribute("message", "Successfully added " + employeeID);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/addEDetailsPage.jsp");
					rd.forward(request, response);
				} 

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("employeeID", employeeID);
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			request.setAttribute("employmentType", employmentType);
			request.setAttribute("salary", salary);
			request.setAttribute("message2", errorMsg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/addEDetailsPage.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
