function displayCategory(here) {
	var case1 = document.getElementsByClassName("switch-case-elements");
	var case2 = document.getElementsByClassName("dropdown");
	var case3 = document.getElementsByClassName("minimise");
	var case4 = document.getElementsByClassName("category-display-link");
	//Cache toutes les catégories d'ouvertes (normalement il ne devrait y avoir qu'une seule)
	Array.prototype.forEach.call(case1, function(element) {
		element.style = "display: none;";
	});
	Array.prototype.forEach.call(case2, function(element) {
		element.style = "display: none;";
	});
	Array.prototype.forEach.call(case3, function(element) {
		element.style = "display: block;";
	});
	Array.prototype.forEach.call(case4, function(element) {
		element.setAttribute('onclick', 'displayCategory(this)');
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