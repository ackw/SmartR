$(document).ready(function() {
	
	$('#successAlert:empty').text("EMPTY").hide();
	$('#dangerAlert:empty').text("EMPTY").hide();
	
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
		var a = document.createElement('a');
        a.setAttribute('download', name + '.png');
        a.setAttribute('href', picture);
        a.click();
		document.querySelector('#download-photo').src = picture;
		$('#photoURL').val(document.getElementById("download-photo").src);
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
	
	downloadImage = function (name, datauri) {
        var a = document.createElement('a');
        a.setAttribute('download', name + '.png');
        a.setAttribute('href', datauri);
        a.click();
    }
});