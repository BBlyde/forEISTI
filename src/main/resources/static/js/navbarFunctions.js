window.onload = function() {
	var boards = new Array('NSFW','Gaming','Shitpost','Politics','Science','Technology');
	boards.forEach(item => displayBoards(item));
}

function displayBoards(item) {
	console.log("testing");
	document.getElementById("boardList").innerHTML += "<li><a href='#'><i class='boardDisplay'></i>> "+item+"</a></li>";
}
