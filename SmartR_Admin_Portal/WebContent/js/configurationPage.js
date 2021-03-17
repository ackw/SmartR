$(document).ready(function() {
	// loading initial page state
	$('#tuesday').hide();
	$('#wednesday').hide();
	$('#thursday').hide();
	$('#friday').hide();
	$('#saturday').hide();
	$('#sunday').hide();
	$('#monday').show();
	$('#monBtn').addClass("clicked");
	$('#successAlert:empty').text("EMPTY").hide();
	$('#dangerAlert:empty').text("EMPTY").hide();
	
	if ($('#monStatus').val() == "closed") {
		console.log('asd');
		$('#monStart').prop("disabled", true);
		$('#monEnd').prop("disabled", true);
		$('#monCheckBox').prop("checked", true);
	}
	
	if ($('#tuesStatus').val() == "closed") {
		console.log('asd');
		$('#tuesStart').prop("disabled", true);
		$('#tuesEnd').prop("disabled", true);
		$('#tuesCheckBox').prop("checked", true);
	}

	if ($('#wedStatus').val() == "closed") {
		console.log('asd');
		$('#wedStart').prop("disabled", true);
		$('#wedEnd').prop("disabled", true);
		$('#wedCheckBox').prop("checked", true);
	}
	
	if ($('#thursStatus').val() == "closed") {
		console.log('asd');
		$('#thursStart').prop("disabled", true);
		$('#thursEnd').prop("disabled", true);
		$('#thursCheckBox').prop("checked", true);
	}
	
	if ($('#friStatus').val() == "closed") {
		console.log('asd');
		$('#friStart').prop("disabled", true);
		$('#friEnd').prop("disabled", true);
		$('#friCheckBox').prop("checked", true);
	}
	
	if ($('#satStatus').val() == "closed") {
		console.log('asd');
		$('#satStart').prop("disabled", true);
		$('#satEnd').prop("disabled", true);
		$('#satCheckBox').prop("checked", true);
	}
	
	if ($('#sunStatus').val() == "closed") {
		console.log('asd');
		$('#sunStart').prop("disabled", true);
		$('#sunEnd').prop("disabled", true);
		$('#sunCheckBox').prop("checked", true);
	}	
	
	// track click events for each day btn
	$('#monBtn').on('click', function(){
		$('#monday').show();
		$('#tuesday').hide();
		$('#wednesday').hide();
		$('#thursday').hide();
		$('#friday').hide();
		$('#saturday').hide();
		$('#sunday').hide();
		$('#monBtn').addClass("clicked");
		$('#tuesBtn').removeClass("clicked");
		$('#wedBtn').removeClass("clicked");
		$('#thursBtn').removeClass("clicked");
		$('#friBtn').removeClass("clicked");
		$('#satBtn').removeClass("clicked");
		$('#sunBtn').removeClass("clicked");
	});
	
	$('#tuesBtn').on('click', function(){
		$('#monday').hide();
		$('#tuesday').show();
		$('#wednesday').hide();
		$('#thursday').hide();
		$('#friday').hide();
		$('#saturday').hide();
		$('#sunday').hide();
		$('#monBtn').removeClass("clicked");
		$('#tuesBtn').addClass("clicked");
		$('#wedBtn').removeClass("clicked");
		$('#thursBtn').removeClass("clicked");
		$('#friBtn').removeClass("clicked");
		$('#satBtn').removeClass("clicked");
		$('#sunBtn').removeClass("clicked");
	});
	
	$('#wedBtn').on('click', function(){
		$('#monday').hide();
		$('#tuesday').hide();
		$('#wednesday').show();
		$('#thursday').hide();
		$('#friday').hide();
		$('#saturday').hide();
		$('#sunday').hide();
		$('#monBtn').removeClass("clicked");
		$('#tuesBtn').removeClass("clicked");
		$('#wedBtn').addClass("clicked");
		$('#thursBtn').removeClass("clicked");
		$('#friBtn').removeClass("clicked");
		$('#satBtn').removeClass("clicked");
		$('#sunBtn').removeClass("clicked");
	});
	
	$('#thursBtn').on('click', function(){
		$('#monday').hide();
		$('#tuesday').hide();
		$('#wednesday').hide();
		$('#thursday').show();
		$('#friday').hide();
		$('#saturday').hide();
		$('#sunday').hide();
		$('#monBtn').removeClass("clicked");
		$('#tuesBtn').removeClass("clicked");
		$('#wedBtn').removeClass("clicked");
		$('#thursBtn').addClass("clicked");
		$('#friBtn').removeClass("clicked");
		$('#satBtn').removeClass("clicked");
		$('#sunBtn').removeClass("clicked");
	});
	
	$('#friBtn').on('click', function(){
		$('#monday').hide();
		$('#tuesday').hide();
		$('#wednesday').hide();
		$('#thursday').hide();
		$('#friday').show();
		$('#saturday').hide();
		$('#sunday').hide();
		$('#monBtn').removeClass("clicked");
		$('#tuesBtn').removeClass("clicked");
		$('#wedBtn').removeClass("clicked");
		$('#thursBtn').removeClass("clicked");
		$('#friBtn').addClass("clicked");
		$('#satBtn').removeClass("clicked");
		$('#sunBtn').removeClass("clicked");
	});
	
	$('#satBtn').on('click', function(){
		$('#monday').hide();
		$('#tuesday').hide();
		$('#wednesday').hide();
		$('#thursday').hide();
		$('#friday').hide();
		$('#saturday').show();
		$('#sunday').hide();
		$('#monBtn').removeClass("clicked");
		$('#tuesBtn').removeClass("clicked");
		$('#wedBtn').removeClass("clicked");
		$('#thursBtn').removeClass("clicked");
		$('#friBtn').removeClass("clicked");
		$('#satBtn').addClass("clicked");
		$('#sunBtn').removeClass("clicked");
	});
	
	$('#sunBtn').on('click', function(){
		$('#monday').hide();
		$('#tuesday').hide();
		$('#wednesday').hide();
		$('#thursday').hide();
		$('#friday').hide();
		$('#saturday').hide();
		$('#sunday').show();
		$('#monBtn').removeClass("clicked");
		$('#tuesBtn').removeClass("clicked");
		$('#wedBtn').removeClass("clicked");
		$('#thursBtn').removeClass("clicked");
		$('#friBtn').removeClass("clicked");
		$('#satBtn').removeClass("clicked");
		$('#sunBtn').addClass("clicked");
	});
	
	// track event for each day check box 
	$('#monCheckBox').on('click', function(){
		if ($('#monCheckBox').prop("checked") == true) {
			$('#monStart').prop("disabled", true);
			$('#monStart').val("");
			$('#monEnd').prop("disabled", true);
			$('#monEnd').val("");
			$('#monStatus').val("closed");
		} else {
			$('#monStart').prop("disabled", false);
			$('#monEnd').prop("disabled", false);
			$('#monStatus').val("open");
		}
	});
	
	$('#tuesCheckBox').on('click', function(){
		if ($('#tuesCheckBox').prop("checked") == true) {
			$('#tuesStart').prop("disabled", true);
			$('#tuesStart').val("");
			$('#tuesEnd').prop("disabled", true);
			$('#tuesEnd').val("");
			$('#tuesStatus').val("closed");
		} else {
			$('#tuesStart').prop("disabled", false);
			$('#tuesEnd').prop("disabled", false);
			$('#tuesStatus').val("open");
		}
	});
	
	$('#wedCheckBox').on('click', function(){
		if ($('#wedCheckBox').prop("checked") == true) {
			$('#wedStart').prop("disabled", true);
			$('#wedStart').val("");
			$('#wedEnd').prop("disabled", true);
			$('#wedEnd').val("");
			$('#wedStatus').val("closed");
		} else {
			$('#wedStart').prop("disabled", false);
			$('#wedEnd').prop("disabled", false);
			$('#wedStatus').val("open");
		}
	});
	
	$('#thursCheckBox').on('click', function(){
		if ($('#thursCheckBox').prop("checked") == true) {
			$('#thursStart').prop("disabled", true);
			$('#thursStart').val("");
			$('#thursEnd').prop("disabled", true);
			$('#thursEnd').val("");
			$('#thursStatus').val("closed");
		} else {
			$('#thursStart').prop("disabled", false);
			$('#thursEnd').prop("disabled", false);
			$('#monStatus').val("open");
		}
	});
	
	$('#friCheckBox').on('click', function(){
		if ($('#friCheckBox').prop("checked") == true) {
			$('#friStart').prop("disabled", true);
			$('#friStart').val("");
			$('#friEnd').prop("disabled", true);
			$('#friEnd').val("");
			$('#friStatus').val("closed");
		} else {
			$('#friStart').prop("disabled", false);
			$('#friEnd').prop("disabled", false);
			$('#friStatus').val("open");
		}
	});
	
	$('#satCheckBox').on('click', function(){
		if ($('#satCheckBox').prop("checked") == true) {
			$('#satStart').prop("disabled", true);
			$('#satStart').val("");
			$('#satEnd').prop("disabled", true);
			$('#satEnd').val("");
			$('#satStatus').val("closed");
		} else {
			$('#satStart').prop("disabled", false);
			$('#satEnd').prop("disabled", false);
			$('#satStatus').val("open");
		}
	});
	
	$('#sunCheckBox').on('click', function(){
		if ($('#sunCheckBox').prop("checked") == true) {
			$('#sunStart').prop("disabled", true);
			$('#sunStart').val("");
			$('#sunEnd').prop("disabled", true);
			$('#sunEnd').val("");
			$('#sunStatus').val("closed");
		} else {
			$('#sunStart').prop("disabled", false);
			$('#sunEnd').prop("disabled", false);
			$('#sunStatus').val("open");
		}
	});
	
	
});