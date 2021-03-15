console.log("11");
$(document).ready(function() {
  

        $('#attendanceList').DataTable( {
            "order": [[ 3, "desc" ]]
        } );


    $(function(){
  	  $("tr").each(function(){
  	    var col_val = $(this).find("td:eq(6)").text();
  	    if (col_val == "true"){
  	      $(this).addClass('late');  
  	      $(this).find('.buttom-custom').css('color', 'white'); 
  	    }
  	  });
  	});
    
    document.getElementById('filter').addEventListener("click", function () {
    	$('#filterStatus').val('true');
	});
} );

