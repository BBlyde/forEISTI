function displayCategory(here,show) {
	var cases = document.getElementsByClassName("switch-case-elements");
	Array.prototype.forEach.call(cases, function(element) {
		element.style = "display: none;";
	});

	console.log(here);
	console.log(show);
	show.style="display: block;";
	here.setAttribute("onclick", "hideCategory(this,"+show.id+")");
	console.log(here.onclick);
}



function hideCategory(here,show) {
	show.style="display: none;";
	here.setAttribute("onclick", "displayCategory(this,"+show.id+")");
}
