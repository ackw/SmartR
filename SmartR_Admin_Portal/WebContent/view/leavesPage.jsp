<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/leavePageCSS.css">

<title>Leave Application Page</title>
</head>
<body>
	<jsp:include page="navBar.jsp" />
	<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
		<div class="container">
	      <div class="card leave-card">
	   	  	<h1 id="title">Leave Application Form</h1>
	   	  	<div class="col-md-12">
	            <div class="card-body">
	            	<form action="#!">
	                  <div class="form-group">
	                    <input type="username" name="username" id="username" class="form-control" placeholder="Employee ID">
	                  </div>
	                 
	                  <div class="form-group form-inline mb-1">
		                 <p id="leaveDuration">Leave Duration:</p>
		                <div class="input-group ml-3">
						  <input type="datetime-local" name="startDate" id="startDate" class="form-control" placeholder=""Start Date">
						  <div class="input-group-prepend"><span class="divider">to</span></div>
						  <input type="datetime-local" name="endDate" id="endDate" class="form-control" placeholder=""End Date">
						</div>
	                  </div>
	                  
	                  <div class="form-group mb-5">
	                    <input type="text" name="reason" id="reason" class="form-control" placeholder="Input Leave Reason">
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