
$(document).ready(function(){
document.getElementById("monbtn").onclick = function() {monFunction()};
document.getElementById("tuebtn").onclick = function() {tueFunction()};
document.getElementById("wedbtn").onclick = function() {wedFunction()};
document.getElementById("thubtn").onclick = function() {thuFunction()};
document.getElementById("fribtn").onclick = function() {friFunction()};
document.getElementById("satbtn").onclick = function() {satFunction()};
document.getElementById("sunbtn").onclick = function() {sunFunction()};


function monFunction() {
    $('#tuesday').hide();
	$('#wednesday').hide();
 	$('#thursday').hide();
 	$('#friday').hide();
 	$('#saturday').hide();
  	$('#sunday').hide();
  	$('#monday').show();
}

function tueFunction() {
    $('#tuesday').show();
	$('#wednesday').hide();
 	$('#thursday').hide();
 	$('#friday').hide();
 	$('#saturday').hide();
  	$('#sunday').hide();
  	$('#monday').hide();
}

function wedFunction() {
    $('#tuesday').hide();
	$('#wednesday').show();
 	$('#thursday').hide();
 	$('#friday').hide();
 	$('#saturday').hide();
  	$('#sunday').hide();
  	$('#monday').hide();
}

function thuFunction() {
    $('#tuesday').hide();
	$('#wednesday').hide();
 	$('#thursday').show();
 	$('#friday').hide();
 	$('#saturday').hide();
  	$('#sunday').hide();
  	$('#monday').hide();
}

function friFunction() {
    $('#tuesday').hide();
	$('#wednesday').hide();
 	$('#thursday').hide();
 	$('#friday').show();
 	$('#saturday').hide();
  	$('#sunday').hide();
  	$('#monday').hide();
}

function satFunction() {
    $('#tuesday').hide();
	$('#wednesday').hide();
 	$('#thursday').hide();
 	$('#friday').hide();
 	$('#saturday').show();
  	$('#sunday').hide();
  	$('#monday').hide();
}

function sunFunction() {
    $('#tuesday').hide();
	$('#wednesday').hide();
 	$('#thursday').hide();
 	$('#friday').hide();
 	$('#saturday').hide();
  	$('#sunday').show();
  	$('#monday').hide();
}
 });
 
