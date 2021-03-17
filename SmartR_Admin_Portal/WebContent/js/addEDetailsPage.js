$(document).ready(function() {
	$('#successAlert:empty').text("EMPTY").hide();
	$('#dangerAlert:empty').text("EMPTY").hide();
	
	$('#employeeList').DataTable( {
   	   
	});
	
	$('#snapImage').hide();
	$('#closeCamera').hide();
	$('#webcamdiv').hide();
	$('#download-photo').hide();
	$('#snapAgainImage').hide();
	
	const webcamElement = document.getElementById('webcam');
	const canvasElement = document.getElementById('canvas');
	const snapSoundElement = document.getElementById('snapSound');
	const webcam = new Webcam(webcamElement, 'user', canvasElement, snapSoundElement);
	
	$('#openCamera').on('click', function(){
		webcam.start()
		$('#openCamera').hide();
		$('#webcamdiv').show();
		$('#snapImage').show();
		$('#closeCamera').show();
		$('#download-photo').hide();
	});
	
	$('#closeCamera').on('click', function(){
		$('#webcamdiv').hide();
		$('#snapImage').hide();
		$('#closeCamera').hide();
		$('#openCamera').show();
		$('#snapAgainImage').hide();
		webcam.stop()
	});
	
	$('#snapImage').on('click', function(){
		let picture = webcam.snap();
		$('#photoURL').val(picture);
		document.querySelector('#download-photo').src = picture;
		$('#download-photo').show();
		$('#webcamdiv').hide();
		$('#snapImage').hide();
		$('#snapAgainImage').show();
		$('#closeCamera').hide();
		webcam.stop()
	});
	
	$('#snapAgainImage').on('click', function(){
		webcam.start()
		$('#snapAgainImage').hide();
		$('#webcamdiv').show();
		$('#snapImage').show();
		$('#download-photo').hide();
		$('#closeCamera').show();
	});	
	
	function dataURItoBlob(dataURI) {
		  var byteString = atob(dataURI.split(',')[1]);

		  var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0]

		  var ab = new ArrayBuffer(byteString.length);

		  var ia = new Uint8Array(ab);

		  for (var i = 0; i < byteString.length; i++) {
		      ia[i] = byteString.charCodeAt(i);
		  }

		  var blob = new Blob([ab], {type: mimeString});
		  console.log(blob);
		  
		  return blob;
		}
	
});