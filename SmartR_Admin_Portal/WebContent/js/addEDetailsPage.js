$(document).ready(function() {
	
	$('#successAlert:empty').text("EMPTY").hide();
	$('#dangerAlert:empty').text("EMPTY").hide();
	
	$('#snapImage').hide();
	$('#closeCamera').hide();
	
	const webcamElement = document.getElementById('webcam');
	const canvasElement = document.getElementById('canvas');
	const snapSoundElement = document.getElementById('snapSound');
	const webcam = new Webcam(webcamElement, 'user', canvasElement, snapSoundElement);
	
	$('#openCamera').on('click', function(){
		webcam.start()
	});
	
	$('#closeCamera').on('click', function(){
		webcam.stop()
	});
	
	
	
	
});