<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/configurationPageCSS.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/configurationPage.js"></script>

<title>Configuration Page</title>
</head>
<body>
	<jsp:include page="navBar.jsp" />
	<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
		<div class="container">
			<div class="card Configuration-card">
				<h1 id="title">Edit Configuration</h1>
				<div class="col-md-12">
					<div class="card-body">
						<form action="ConfigurationPageServlet" method="post">
							<div class="form-group">
								<p>Operating Hours:</p>
								<div id="monday" class="form-group form-inline mb-1">
									<div class="input-group">
										<input type="time" name="monStart" id="monStart"
											value="${monStart}" class="form-control">
										<div class="input-group-prepend">
											<span class="divider">to</span>
										</div>
										<input type="time" name="monEnd" id="monEnd"
											value="${monEnd}" class="form-control">
									</div>
									<div class="form-check ml-3 mb-3">
										<input type="checkbox" class="form-check-input"
											id="monCheckBox"> <label class="form-check-label"
											for="monCheckBox">Closed</label>
											<input type="hidden" id="monStatus" name="monStatus" value="${tuesStatus}" />
									</div>
								</div>

								<div id="tuesday" class="form-group form-inline mb-1">
									<div class="input-group">
										<input type="time" name="tuesStart" id="tuesStart"
											value="${tuesStart}" class="form-control">
										<div class="input-group-prepend">
											<span class="divider">to</span>
										</div>
										<input type="time" name="tuesEnd" id="tuesEnd"
											value="${tuesEnd}" class="form-control">
									</div>
									<div class="form-check ml-3 mb-3">
										<input type="checkbox" class="form-check-input"
											id="tuesCheckBox"> <label class="form-check-label"
											for="tuesCheckBox">Closed</label>
											<input type="hidden" id="tuesStatus" name="tuesStatus" value="${tuesStatus}" />
									</div>
								</div>

								<div id="wednesday" class="form-group form-inline mb-1">
									<div class="input-group">
										<input type="time" name="wedStart" id="wedStart"
											value="${wedStart}" class="form-control">
										<div class="input-group-prepend">
											<span class="divider">to</span>
										</div>
										<input type="time" name="wedEnd" id="wedEnd"
											value="${wedEnd}" class="form-control">
									</div>
									<div class="form-check ml-3 mb-3">
										<input type="checkbox" class="form-check-input"
											id="wedCheckBox"> <label class="form-check-label"
											for="wedCheckBox">Closed</label>
											<input type="hidden" id="wedStatus" name="wedStatus" value="${wedStatus}" />
									</div>
								</div>

								<div id="thursday" class="form-group form-inline mb-1">
									<div class="input-group">
										<input type="time" name="thursStart" id="thursStart"
											value="${thursStart}" class="form-control">
										<div class="input-group-prepend">
											<span class="divider">to</span>
										</div>
										<input type="time" name="thursEnd" id="thursEnd"
											value="${thursEnd}" class="form-control">
									</div>
									<div class="form-check ml-3 mb-3">
										<input type="checkbox" class="form-check-input"
											id="thursCheckBox"> <label class="form-check-label"
											for="thursCheckBox">Closed</label>
											<input type="hidden" id="thursStatus" name="thursStatus" value="${thursStatus}" />
									</div>
								</div>

								<div id="friday" class="form-group form-inline mb-1">
									<div class="input-group">
										<input type="time" name="friStart" id="friStart"
											value="${friStart}" class="form-control">
										<div class="input-group-prepend">
											<span class="divider">to</span>
										</div>
										<input type="time" name="friEnd" id="friEnd"
											value="${friEnd}" class="form-control">
									</div>
									<div class="form-check ml-3 mb-3">
										<input type="checkbox" class="form-check-input"
											id="friCheckBox"> <label class="form-check-label"
											for="friCheckBox">Closed</label>
											<input type="hidden" id="friStatus" name="friStatus" value="${friStatus}" />
									</div>
								</div>

								<div id="saturday" class="form-group form-inline mb-1">
									<div class="input-group">
										<input type="time" name="satStart" id="satStart"
											value="${satStart}" class="form-control">
										<div class="input-group-prepend">
											<span class="divider">to</span>
										</div>
										<input type="time" name="satEnd" id="satEnd"
											value="${satEnd}" class="form-control">
									</div>
									<div class="form-check ml-3 mb-3">
										<input type="checkbox" class="form-check-input"
											id="satCheckBox"> <label class="form-check-label"
											for="satCheckBox">Closed</label>
											<input type="hidden" id="satStatus" name="satStatus" value="${satStatus}" />
									</div>
								</div>

								<div id="sunday" class="form-group form-inline mb-1">
									<div class="input-group">
										<input type="time" name="sunStart" id="sunStart"
											value="${sunStart}" class="form-control">
										<div class="input-group-prepend">
											<span class="divider">to</span>
										</div>
										<input type="time" name="sunEnd" id="sunEnd"
											value="${sunEnd}" class="form-control">
									</div>
									<div class="form-check ml-3 mb-3">
										<input type="checkbox" class="form-check-input"
											id="sunCheckBox"> <label class="form-check-label"
											for="sunCheckBox">Closed</label>
											<input type="hidden" id="sunStatus" name="sunStatus" value="${sunStatus}" />
									</div>
								</div>
							</div>

							<div id="selectDay" class="form-group form-inline mt-5 mb-6">
								<button id="monBtn" type="button" class="btn btn-primary">Mon</button>
								<button id="tuesBtn" type="button" class="btn btn-primary ml-2">Tues</button>
								<button id="wedBtn" type="button" class="btn btn-primary ml-2">Wed</button>
								<button id="thursBtn" type="button" class="btn btn-primary ml-2">Thurs</button>
								<button id="friBtn" type="button" class="btn btn-primary ml-2">Fri</button>
								<button id="satBtn" type="button" class="btn btn-primary ml-2">Sat</button>
								<button id="sunBtn" type="button" class="btn btn-primary ml-2">Sun</button>
							</div>

							<div class="form-group mt-3">
								<p>Grace Period (minutes) - Max 60:</p>
								<input type="number" name="gracePeriod" id="gracePeriod"
								class="form-control" placeholder="Grace Period" value="${gracePeriod}" min="0" max="60">
							</div>


							<div class="form-group mb">
								<p>Notification Email:</p>
								<input type="email" name="notiEmail" id="notiEmail" class="form-control" value="${notiEmail}">
							</div>

							<p>Notification Password:</p>
							<div class="form-group mb-4">
								<input type="password" name="notiPW" id="notiPW" value="${notiPW}"
									class="form-control">
							</div>


							<input name="submit" id="submit"
								class="btn btn-block submit-btn mb-4" type="submit" value="Save">
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>