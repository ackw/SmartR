package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UsersDaoImpl;
import com.models.Users;
import com.postgresConnection.JdbcConnection;


@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/loginPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Request username and password entered
			Users user = new Users();
			user.setUsername(request.getParameter("username"));
		    user.setPassword(request.getParameter("password"));

			// check if username and password entered is correct
			UsersDaoImpl userDAO = new UsersDaoImpl();
			boolean successful = userDAO.login(user.getUsername(), user.getPassword());

			if (successful == true) {
				// set current session to logged in user
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user.getUsername());
				response.sendRedirect("./AttendancePageServlet");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("window.confirm('Login details incorrect! Please try again.');");
				out.println("document.location='/SmartR_Admin_Portal';");
				out.println("</script>");
			}
		} catch (Exception e) {
			System.out.println("Login failed." + e.getMessage());
		} finally {

		}
		
	}
}