window.onload = function() {
	for (let msg of document.getElementsByClassName("post-text")) {
		var matches = msg.innerHTML.match(/&gt;&gt;\d+/g);
		if (matches == null)
			continue;
		for (let match of matches) {
			var id = match.match(/\d+/)[0];
			if (document.getElementById("p" + id) != null)
				msg.innerHTML = msg.innerHTML.replace(match, "<a href=\"#p" + id + "\">" + match + "</a>");
			else
				msg.innerHTML = msg.innerHTML.replace(match, "<s>" + match + "</s>");
		}
	}
}
