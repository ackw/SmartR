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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/leavePageCSS.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/css/bootstrap-select.css" />


<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/js/bootstrap-select.min.js"></script>
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
						<form action="LeavesPageServlet" method="POST" id="dateSelect"> <input type="month" name="date" id="date" class="form-control"
							value="${date}"></form>
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
									<div class="calendar__day day">${listOfDays}<br>
										<c:forEach var="days" items="${leavesRecord}"
											varStatus="status">
											<c:if test="${days.key == listOfDays}">
												<c:forEach var="leaves" items="${days.value}"
													varStatus="status">
													<a class="dataPass" id="dataPass" href=""
														data-toggle="modal" data-target="#viewDetails"
														data-todo="${leaves.getEmployee_id()}/${leaves.getStart_date()}/${leaves.getEnd_date()}/${leaves.getReason()}">${leaves.getEmployee_id()}</a>
												</c:forEach>
											</c:if>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
						</c:forEach>

						<div class="modal fade" id="viewDetails" tabindex="-1"
							role="dialog" aria-labelledby="viewReasonModal"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Leave
											Details</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<div class="row ml-3">
											<p>
												<b>Employee ID: </b>
											</p>
											<p class="ml-3" id="employee_id_text"></p>
										</div>

										<div class="row ml-3">
											<p>
												<b>Start Date: </b>
											</p>
											<p class="ml-3" id="startDate_text"></p>
										</div>

										<div class="row ml-3">
											<p>
												<b>End Date: </b>
											</p>
											<p class="ml-3" id="endDate_text"></p>
										</div>

										<div class="row ml-3">
											<p>
												<b>Reason: </b>
											</p>
											<p class="ml-3" id="reason_text"></p>
										</div>

									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger">Delete
											Leave Record</button>
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
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
					<div id="successAlert" class="alert alert-success" role="alert">${message}</div>
					<div id="dangerAlert" class="alert alert-danger" role="alert">${message2}</div>
					<form id="leaveForm" action="LeavesPageServlet" method="POST">
						<div class="form-group">
							<select name="nameList" id="nameList" class="selectpicker"
								data-live-search="true" title="Search by name">
								<c:forEach items="${allEmployeeMap}" var="item"
									varStatus="status">
									<option>${item.key}-${item.value.getName()}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group form-inline mb-3">
							<p class="mt-3" id="leaveDuration">Leave Duration:</p>
							<div class="input-group ml-3">
								<input type="date" name="startDate" id="startDate"
									class="form-control" value="${startDate}">
								<div class="input-group-prepend">
									<span class="divider">to</span>
								</div>
								<input type="date" name="endDate" id="endDate"
									class="form-control" value="${endDate}">
							</div>
						</div>

						<div class="form-group mb-5">
							<input type="text" name="reason" id="reason" class="form-control"
								placeholder="Input Leave Reason" value="${reason}">
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