function displayCategory(here) {
	
	var cases = document.getElementsByClassName("switch-case-elements");
	Array.prototype.forEach.call(cases, function(element) {
		element.style = "display: none;";
	});

	document.getElementById(here.parentNode.parentNode.parentNode.id).getElementsByClassName("switch-case-elements")[0].style="display:flex";
	document.getElementById(here.parentNode.parentNode.parentNode.id).getElementsByClassName("minimise")[0].style="display:none";
	document.getElementById(here.parentNode.parentNode.parentNode.id).getElementsByClassName("dropdown")[0].style="display:block";
	here.setAttribute('onclick', 'hideCategory(this)');
}



function hideCategory(here) {
	document.getElementById(here.parentNode.parentNode.parentNode.id).getElementsByClassName("switch-case-elements")[0].style="display:none";
	document.getElementById(here.parentNode.parentNode.parentNode.id).getElementsByClassName("minimise")[0].style="display:block";
	document.getElementById(here.parentNode.parentNode.parentNode.id).getElementsByClassName("dropdown")[0].style="display:none";
	here.setAttribute('onclick', 'displayCategory(this)');
}
