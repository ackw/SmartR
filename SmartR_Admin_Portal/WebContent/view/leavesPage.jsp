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
	href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/leavePageCSS.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/leavePage.js"></script>

<title>Leave Application Page</title>
</head>
<body>
	<div id="calendar"></div>

	<jsp:include page="navBar.jsp" />
	<div class="container mt-5">
		<div class="card leave-card">
			<div class="col-md-12">
				<div class="card-body">
					<h1 id="title">Leave Records</h1>
					<div class="toolbar">
						<input type="month" name="date" id="date"
						class="form-control" value="${date}">
					</div>
					<div class="calendar">
						<div class="calendar__header">
							<div>mon</div>
							<div>tue</div>
							<div>wed</div>
							<div>thu</div>
							<div>fri</div>
							<div>sat</div>
							<div>sun</div>
						</div>
						<c:forEach items="${calendarList}" var="listOfWeeks"
							varStatus="status">
							<div class="calendar__week">
								<c:forEach items="${listOfWeeks}" var="listOfDays"
									varStatus="status">
										<div class="calendar__day day">${listOfDays}</div>
								</c:forEach>
							</div>
						</c:forEach>	
					</div>
					<br>
				</div>
			</div>
		</div>
	</div>

	<div class="container mt-5 mb-5">
		<div class="card leave-card">
			<div class="col-md-12">
				<div class="card-body">
					<h1 id="title">Leave Application Form</h1>
					<form action="#!">
						<div class="form-group">
							<input type="username" name="username" id="username"
								class="form-control" placeholder="Employee ID">
						</div>

						<div class="form-group form-inline mb-3">

							<p class="mt-3" id="leaveDuration">Leave Duration:</p>
							<div class="input-group ml-3">
								<input type="date" name="startDate" id="startDate"
									class="form-control" placeholder=""StartDate">
								<div class="input-group-prepend">
									<span class="divider">to</span>
								</div>
								<input type="date" name="endDate" id="endDate"
									class="form-control" placeholder=""EndDate">
							</div>
						</div>

						<div class="form-group mb-5">
							<input type="text" name="reason" id="reason" class="form-control"
								placeholder="Input Leave Reason">
						</div>

						<input name="submit" id="submit"
							class="btn btn-block submit-btn mb-4" type="button"
							value="Submit">
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>