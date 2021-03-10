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
<link rel="stylesheet" href="css/attendancePageCSS.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/css/bootstrap-select.css" />



<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/js/bootstrap-select.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="js/attendancePage.js"></script>



<title>Attendance Page</title>
</head>
<body>
	<jsp:include page="navBar.jsp" />
	<div class="container">
		<h1 id="title">Attendance List</h1>

		<form action="AttendancePage" method=POST>
			<div class="form-row">
				<div class="form-group col-md-3">
					<select name="nameList" id="nameList" class="selectpicker"
						data-live-search="true" title="Filter by names" multiple>
						<c:forEach items="${allemployeeList}" var="item"
							varStatus="status">
							<option>${item.value.getName()}</option>
						</c:forEach>
					</select>
				</div>

				<div class="input-group col-md-5">
					<input type="date" name="startDate" id="startDate"
						class="form-control">
					<div class="input-group-prepend">
						<span class="divider">to</span>
					</div>
					<input type="date" name="endDate" id="endDate" class="form-control">
				</div>

				<div class="form-group col-md-2">
					<select class="form-control" name="employmentType"
						id="employmentType">
						<option disabled selected>Employment Type</option>
						<option>Full Time</option>
						<option>Part Time</option>
					</select>
				</div>

				<input type="hidden" id="filterStatus" name="filterStatus"
					value="false" />

				<div class="form-group col-md-2">
					<input name="filter" id="filter" class="btn filter-btn"
						type="submit" value="Filter">
				</div>
			</div>
		</form>
		<table id="attendanceList" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>Employment ID</th>
					<th>Name</th>
					<th>Employment Type</th>
					<th>Date</th>
					<th>Time Checked-In</th>
					<th>Time Checked-Out</th>
					<th style="display: none;">Is Late</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allAttendanceList}" var="item"
					varStatus="status">
					<tr>
						<td>${allAttendanceList[status.index].getEmployee_id()}</td>
						<td>${employeeList[status.index].getName()}</td>
						<td>${employeeList[status.index].getEmployment_type()}</td>
						<td>${allAttendanceList[status.index].getDate()}</td>
						<td>${allAttendanceList[status.index].getTime_check_in()} HRS</td>
						<td>${allAttendanceList[status.index].getTime_check_out()} HRS</td>
						<td style="display: none;">${allAttendanceList[status.index].isIs_late()}</td>
						<td>
							<div class="dropdown">
								<button class="btn btn-primary-outline dropdown-toggle"
									type="button" data-toggle="dropdown">
									Actions <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li class="dropdown-item"><a href="#" data-toggle="modal"
										data-target="#exampleModal">View Reason</a></li>
									<li class="dropdown-item"><a href="#">Edit Row</a></li>
								</ul>
							</div>

							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Modal
												title</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">...</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary">Save
												changes</button>
										</div>
									</div>
								</div>
							</div> ${allAttendanceList[status.index].getReason()}</td>
					</tr>
				</c:forEach>
			</tbody>
			</tfoot>
		</table>

	</div>


</body>
</html>