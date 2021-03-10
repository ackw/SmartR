<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/addEDetailsPageCSS.css">

<title>Add Employee Details Page</title>
</head>
<body>
<jsp:include page="navBar.jsp" />
	<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
		<div class="container">
	      <div class="card EDetails-card">
	   	  	<h1 id="title">New Employee Details Form</h1>
	   	  	<div class="col-md-12">
	            <div class="card-body">
	            	<form action="#!">
	                  <div class="form-group">
	                    <input type="text" name="employeeID" id="employeeID" class="form-control" placeholder="Employee ID">
	                  </div>
	                  
	                  <div class="form-group mb">
	                    <input type="text" name="name" id="name" class="form-control" placeholder="Name">
	                  </div>
	                  
	                  <div class="form-group mb">
	                    <input type="email" name="email" id="email" class="form-control" placeholder="Email">
	                  </div>
	                  
	                  <div class="form-group mb">
	                    <select class="form-control" id="employmentType">
						    <option disabled selected>Employment Type</option>
						    <option>Full Time</option>
						    <option>Part Time</option>
						  </select>
	                  </div>
	                  
	                  <div class="form-group">
	                    <input type="number" name="salary" id="salary" class="form-control" placeholder="Salary">
	                  </div>
	                  
	                  <div class="form-group mb-5">
	                  	<input name="captureImage" id="captureImage" class="btn btn-block capture-btn mb-4" type="button" value="Capture Image">
					  </div>
					  
	                  <input name="submit" id="submit" class="btn btn-block submit-btn mb-4" type="button" value="Submit">
	                </form>
	            </div>
	        </div>
	   	  </div>
	    </div>
    </main>
</body>
</html>