$(document).ready(function() {
	$('#successAlert:empty').text("EMPTY").hide();
	$('#dangerAlert:empty').text("EMPTY").hide();
	
	$('.dataPass').on('click', function(){
		var details = $(this).data("todo");
		console.log(details);
		var array = details.split('/'),
	    a = array[0], b = array[1], c = array[2], d = array[3];
		$("#employee_id_text").text(a);
		$("#startDate_text").text(b);
		$("#endDate_text").text(c);
		$("#reason_text").text(d);
	})
	
	// Limiting overlapping and past date selection!
	var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;

	$('#startDate').attr('min', maxDate);
	$('#endDate').attr('min', maxDate);

	$('#startDate').on('change', function(){
		var selectedDate = $('#startDate').val();
		$('#endDate').attr('min', selectedDate);
	});
	
	$('#endDate').on('change', function(){
		var selectedDate = $('#endDate').val();
		$('#startDate').attr('max', selectedDate);
	});
	
	// send request to servlet to retrieve leave details for selected month
	$('#date').on('change', function(){
		$('#dateSelect').submit();
	});
	
	$('#submit').on('click', function(){
		$('#dateSelect').submit();
		$('leaveForm').submit();
	});
	
});