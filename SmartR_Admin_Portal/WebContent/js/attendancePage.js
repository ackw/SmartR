console.log("11");
$(document).ready(function() {
    $('#attendanceList').DataTable();

    $(function(){
  	  $("tr").each(function(){
  	    var col_val = $(this).find("td:eq(6)").text();
  	    if (col_val == "true"){
  	      $(this).addClass('late');  
  	      $(this).find('.btn').css('color', 'white'); 
  	    }
  	  });
  	});
    
    document.getElementById('filter').addEventListener("click", function () {
    	$('#filterStatus').val('true');
	});
} );

