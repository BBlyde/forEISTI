const handle = window.location.pathname.split("/")[1];

function showThreadCreator() {
	if (!document.getElementById("thread-replier").classList.contains("hidden"))
		hideThreadReplier();
	document.getElementById("thread-creator").classList.remove("hidden");
}

function hideThreadCreator() {
	document.getElementById("thread-creator").classList.add("hidden");
}

function showThreadReplier(thread, post) {
	if (!document.getElementById("thread-creator").classList.contains("hidden"))
		hideThreadCreator();
	var form = document.getElementById("thread-replier");
	if (form.action != "/" + handle + "/thread/" + thread + "/reply") {
		document.getElementById("tr-header").innerHTML = "Reply to thread #" + thread;
		form["tr-text"].innerHTML = "";
		form.action = "/" + handle + "/thread/" + thread + "/reply";
	}
	form["tr-text"].innerHTML += ">>" + post;
	form.classList.remove("hidden");
}

function hideThreadReplier() {
	document.getElementById("thread-replier").classList.add("hidden");
}
