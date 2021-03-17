package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/RestrictServletsFilter")
public class RestrictServletsFilter implements Filter {

    public RestrictServletsFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;	
		HttpSession session = req.getSession(false);

		String loginURI = req.getContextPath() + "/Login";
		String requestURI = req.getRequestURI();

		// checks if user is logged in 
		boolean loggedIn = session != null && session.getAttribute("currentSessionUser") != null;
		// checks if login request equals to login page
		boolean loginRequest = requestURI.equals(loginURI);

		if (loggedIn == true) {
			// if logged in already but still want to access login page
			if (loginRequest == true) {
				res.sendRedirect("./AttendancePage");
			} else {
				chain.doFilter(request, response);
			}
		} else { 
			// else - not logged in
			// if it is requesting for login page, allow access
			if (loginRequest == true) {
				chain.doFilter(request, response);
			} else { 
				// if its not login page,
				// means it is requesting for other servlets
				// disallow access
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("window.confirm('You are not allowed on this page! \\nYou are either not logged in, or session has timed out.');");
				out.println("document.location='" + loginURI + "';");
				out.println("</script>");
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
