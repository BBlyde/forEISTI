function sendNewCategory() {
	var fd = new FormData();
	fd.append("new", document.forms["cat-manager"]["new-cat"].value);
	fetch("/admin/add-category", {
		method: "POST",
		body: fd
	})
	.then((result) => {
		if (result.status != 200)
			throw new Error("Bad server response");
		return result.text();
	})
	.then((content) => {
		try {
			json = JSON.parse(content);
			if (json.ok)
				alert("do stuff");
			else
				alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}
