console.log("11");
$(document).ready(function() {
    $('#attendanceList').DataTable( {
    	 dom: 'Bfrtip',
         buttons: [
             'copy', 'csv', 'excel', 'pdf', 'print'
         ],
    	"order": [[3, "desc" ], [0, "asc"]]
    
    } );

    $(function() {
  	  $("tr").each(function(){
  	    var col_val = $(this).find("td:eq(6)").text();
  	    if (col_val == "1"){
  	      $(this).addClass('late');  
  	    }
  	  });
  	});
    
    $(function() {
    	  $("tr").each(function(){
    	    var col_val = $(this).find("td:eq(4)").text();
    	    if (col_val == "Leave"){
    	      $(this).addClass('leave');  
    	    }
    	  });
    	});
    
    document.getElementById('filter').addEventListener("click", function () {
    	$('#filterStatus').val('true');
	});
    
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

	$('#startDate').attr('max', maxDate);
	$('#endDate').attr('max', maxDate);

	$('#startDate').on('change', function(){
		var selectedDate = $('#startDate').val();
		$('#endDate').attr('min', selectedDate);
	});
	
	$('#endDate').on('change', function(){
		var selectedDate = $('#endDate').val();
		$('#startDate').attr('max', selectedDate);
	});
} );

