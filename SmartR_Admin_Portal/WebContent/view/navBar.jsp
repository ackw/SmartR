<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="css/navBarCSS.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<nav>
		<img class="navLogo" src="images/Logo1.png" />
		<ul>
			<li><a href="AttendancePage"> <img class="icon"
					src="images/ViewAttendanceIcon.png" /><span><br>View
						Attendance</span></a></li>
			<li><a href="LeavesPage"> <img class="icon"
					src="images/InputLeavesIcon.png" /><span><br>Input
						Leaves</span></a></li>
			<li><a href="EmployeeDetailsPage"> <img class="icon"
					src="images/AddNewEmployeeIcon.png" /><span><br>Add New
						Employee Details</span></a></li>
			<li><a href="ConfigrationsPage"> <img class="icon"
					src="images/EditConfigIcon.png" /><span><br>Edit
						Settings</span></a></li>
		</ul>
	</nav>
	<div class="logoutLblPos">
	<form align="right" method="get" action="LogoutPageServlet">
		Welcome, <span class="material-icons">account_circle</span> ${currentSessionUser} |
		<button type="submit" class="btn custom-btn mb-1">Logout</button>
	</form>
</div>
</body>
</html>