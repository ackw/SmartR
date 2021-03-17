<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/addEDetailsPageCSS.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/css/bootstrap-select.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css" />


<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/js/bootstrap-select.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="js/addEDetailsPage.js"></script>
<title>Add Employee Details Page</title>
</head>
<body>
	<jsp:include page="navBar.jsp" />
	<div class="container mt-5">
		<div class="card EDetails-card">
			<h1 id="title">New Employee Details Form</h1>
			<div class="col-md-12">
				<div class="card-body">
					<div id="successAlert" class="alert alert-success" role="alert">${message}</div>
					<div id="dangerAlert" class="alert alert-danger" role="alert">${message2}</div>
					<form action="AddEDetailsPageServlet" method="post">
						<div class="form-group">
							<input type="text" name="employeeID" id="employeeID"
								class="form-control" placeholder="Employee ID*"
								value="${employeeID}">
						</div>

						<div class="form-group mb">
							<input type="text" name="name" id="name" class="form-control"
								placeholder="Name*" value="${name}">
						</div>

						<div class="form-group mb">
							<input type="email" name="email" id="email" class="form-control"
								placeholder="Email" value="${email}">
						</div>

						<div class="form-group mb">
							<select class="form-control" id="employmentType"
								name="employmentType">
								<option disabled selected>Employment Type*</option>
								<option>Full Time</option>
								<option>Part Time</option>
							</select>
						</div>

						<div class="form-group">
							<input type="number" name="salary" id="salary"
								class="form-control" placeholder="Salary*" value="${salary}">
						</div>

						<div id="webcamdiv">
							<video id="webcam" autoplay playsinline width="640" height="480"></video>
							<canvas id="canvas" class="d-none"></canvas>
							<audio id="snapSound" src="audio/snap.wav" preload="auto"></audio>
						</div>

						<img id="download-photo" src="" width=640 " height="480"> <input
							type="hidden" id="photoURL" name="photoURL" value="" />

						<div class="form-group">
							<input name="openCamera" id="openCamera"
								class="btn btn-block capture-btn mb-4" type="button"
								value="Capture Image - Open Camera">
						</div>

						<div class="form-group form-inline mb-5">
							<div class="form-group">
								<input name="snapAgainImage" id="snapAgainImage"
									class="btn btn-block capture-btn" type="button"
									value="Retake image">
							</div>

							<div class="form-group">
								<input name="snapImage" id="snapImage"
									class="btn btn-block capture-btn" type="button"
									value="Snap Image">
							</div>

							<div class="form-group ml-3">
								<input name="closeCamera" id="closeCamera"
									class="btn btn-block capture-btn" type="button"
									value="Close Camera">
							</div>
						</div>
						<input name="submit" id="submit"
							class="btn btn-block submit-btn mb-4" type="submit"
							value="Submit">
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container mt-5 mb-5">
		<div class="card EDetails-card">
			<div class="col-md-12">
				<div class="card-body">
					<table id="employeeList" class="table table-bordered"
						style="width: 100%">
						<thead>
							<tr>
								<th>Employment ID</th>
								<th>Name</th>
								<th>Employment Type</th>
								<th>Email</th>
								<th>Salary</th>
								<th>Image</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allEmployees}" var="item"
								varStatus="status">
								<tr>
									<td>${allEmployees[status.index].getEmployee_id()}</td>
									<td>${allEmployees[status.index].getName()}</td>
									<td>${allEmployees[status.index].getEmployment_type()}</td>
									<td>${allEmployees[status.index].getEmail()}</td>
									<td>$ ${allEmployees[status.index].getSalary()}</td>
									<td><img class="img" src="data:image/png;base64,${imageURLList[status.index]}"></td>
									<td>Action</td>
								</tr>
							</c:forEach>
						</tbody>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>