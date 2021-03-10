<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/configurationPageCSS.css">

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
	            	<form action="#!">
	                  <div class="form-group">
	                    <p>Operating Hours:</p>
	                    <div id="monday" class="form-group form-inline mb-1">
			                <div class="input-group ml-3">
							  <input type="time" name="monStartTime" id="monStartTime" value="09:30:00" class="form-control">
							  <div class="input-group-prepend"><span class="divider">to</span></div>
							  <input type="time" name="monEndTime" id="monEndTime" value="17:30:00" class="form-control">
							</div>
							<div class="form-check ml-3 mb-3">
							    <input type="checkbox" class="form-check-input" id="monCheckBox">
							    <label class="form-check-label" for="monCheckBox">Closed</label>
							 </div>						
	                  	</div>
	                  	
	                  	 <div id="tuesday" class="form-group form-inline mb-1">
			                <div class="input-group ml-3">
							  <input type="time" name="tueStartTime" id="tueStartTime" value="09:30:00" class="form-control">
							  <div class="input-group-prepend"><span class="divider">to</span></div>
							  <input type="time" name="tueEndTime" id="tueEndTime" value="17:30:00" class="form-control">
							</div>
							<div class="form-check ml-3 mb-3">
							    <input type="checkbox" class="form-check-input" id="tueCheckBox">
							    <label class="form-check-label" for="tueCheckBox">Closed</label>
							 </div>						
	                  	</div>
	                  	
	                  	 <div id="wednesday" class="form-group form-inline mb-1">
			                <div class="input-group ml-3">
							  <input type="time" name="wedStartTime" id="wedStartTime" value="09:30:00" class="form-control">
							  <div class="input-group-prepend"><span class="divider">to</span></div>
							  <input type="time" name="wedEndTime" id="wedEndTime" value="17:30:00" class="form-control">
							</div>
							<div class="form-check ml-3 mb-3">
							    <input type="checkbox" class="form-check-input" id="wedCheckBox">
							    <label class="form-check-label" for="wedCheckBox">Closed</label>
							 </div>						
	                  	</div>
	                  	
	                  	 <div id="thursday" class="form-group form-inline mb-1">
			                <div class="input-group ml-3">
							  <input type="time" name="thursStartTime" id="thursStartTime" value="09:30:00" class="form-control">
							  <div class="input-group-prepend"><span class="divider">to</span></div>
							  <input type="time" name="thursEndTime" id="thursEndTime" value="17:30:00" class="form-control">
							</div>
							<div class="form-check ml-3 mb-3">
							    <input type="checkbox" class="form-check-input" id="thursCheckBox">
							    <label class="form-check-label" for="thursCheckBox">Closed</label>
							 </div>						
	                  	</div>
	                  	
	                  	 <div id="friday" class="form-group form-inline mb-1">
			                <div class="input-group ml-3">
							  <input type="time" name="friStartTime" id="friStartTime" value="09:30:00" class="form-control">
							  <div class="input-group-prepend"><span class="divider">to</span></div>
							  <input type="time" name="friEndTime" id="friEndTime" value="17:30:00" class="form-control">
							</div>
							<div class="form-check ml-3 mb-3">
							    <input type="checkbox" class="form-check-input" id="friCheckBox">
							    <label class="form-check-label" for="friCheckBox">Closed</label>
							 </div>						
	                  	</div>
	                  	
	                  	 <div id="saturday" class="form-group form-inline mb-1">
			                <div class="input-group ml-3">
							  <input type="time" name="satStartTime" id="satStartTime" value="09:30:00" class="form-control">
							  <div class="input-group-prepend"><span class="divider">to</span></div>
							  <input type="time" name="satEndTime" id="satEndTime" value="17:30:00" class="form-control">
							</div>
							<div class="form-check ml-3 mb-3">
							    <input type="checkbox" class="form-check-input" id="satCheckBox">
							    <label class="form-check-label" for="satCheckBox">Closed</label>
							 </div>						
	                  	</div>
	                  	
	                  	 <div id="sunday" class="form-group form-inline mb-1">
			                <div class="input-group ml-3">
							  <input type="time" name="sunStartTime" id="sunStartTime" value="09:30:00" class="form-control">
							  <div class="input-group-prepend"><span class="divider">to</span></div>
							  <input type="time" name="sunEndTime" id="sunEndTime" value="17:30:00" class="form-control">
							</div>
							<div class="form-check ml-3 mb-3">
							    <input type="checkbox" class="form-check-input" id="sunCheckBox">
							    <label class="form-check-label" for="sunCheckBox">Closed</label>
							 </div>						
	                  	</div>
	                  </div>
	                  
	                  <div id="selectDay" class="form-group form-inline mb-6">
		                <button type="button" class="btn btn-primary">Mon</button>
		                <button type="button" class="btn btn-primary ml-2">Tues</button>
		                <button type="button" class="btn btn-primary ml-2">Wed</button>
		                <button type="button" class="btn btn-primary ml-2">Thurs</button>
		                <button type="button" class="btn btn-primary ml-2">Fri</button>
		                <button type="button" class="btn btn-primary ml-2">Sat</button>
		                <button type="button" class="btn btn-primary ml-2">Sun</button>
	                  </div>
	                  
	                  <div class="form-group mt-3">
	                  	<p>Grace Period:</p>
	                    <select class="form-control" id="employmentType">
						    <option selected>5 Minutes</option>
						    <option>10 Minutes</option>
						    <option>15 Minutes</option>
						    <option>20 Minutes</option>
						    <option>25 Minutes</option>
						    <option>30 Minutes</option>
						    <option>35 Minutes</option>
						    <option>40 Minutes</option>
						    <option>45 Minutes</option>
						    <option>50 Minutes</option>
						    <option>55 Minutes</option>
						    <option>60 Minutes</option>
						  </select>
	                  </div>
	                 
	                  
	                  <div class="form-group mb">
	                  <p>Notification Email:</p>
	                    <input type="email" name="email" id="email" class="form-control">
	                  </div>
	                  
	                  <p>Notification Password:</p>
	                  <div class="form-group mb-4">
	                    <input type="password" name="password" id="password" class="form-control">
	                  </div>
	                  
					  
	                  <input name="submit" id="submit" class="btn btn-block submit-btn mb-4" type="button" value="Save">
	                </form>
	            </div>
	        </div>
	   	  </div>
	    </div>
    </main>
</body>
</html>