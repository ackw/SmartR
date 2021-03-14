<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="css/navBarCSS.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>					
	<nav>
		<img class="navLogo" src="images/Logo1.png"/>
		<ul>
			<li><a href="AttendancePage"> <img class="icon" src="images/ViewAttendanceIcon.png"/><span><br>View Attendance</span></a></li>
			<li><a href="LeavesPageServlet"> <img class="icon" src="images/InputLeavesIcon.png"/><span><br>Input Leaves</span></a></li>
			<li><a href="AddEDetailsPageServlet"> <img class="icon" src="images/AddNewEmployeeIcon.png"/><span><br>Add New Employee Details</span></a></li>
			<li><a href="ConfigurationPageServlet"> <img class="icon" src="images/EditConfigIcon.png"/><span><br>Edit Settings</span></a></li>
		</ul>
	</nav>
	
	<form align="right" name="form1" method="post" action="log_out.php">
	  <button type="button" class="btn"><span class="material-icons">account_circle</span></button>
	  <label class="logoutLblPos">
	  <input name="submit2" type="submit" id="submit2" value="Logout">
	  </label>
	</form>
</body>
</html>