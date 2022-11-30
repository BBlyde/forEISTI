/* Frontend code */

function addCategoryRow(id, catName) {
	div = document.createElement("div");
	div.id = "cat-" + id;

	nameField = document.createElement("input");
	nameField.id = "cat-" + id + "-name";
	nameField.type = "text";
	nameField.value = catName;
	nameField.placeholder = "Category name";
	div.append(nameField);

	editBtn = document.createElement("button");
	editBtn.type = "button";
	editBtn.setAttribute("onclick", "editCategory(" + id + ");");
	editBtn.innerHTML = "Rename";
	div.append(editBtn);

	deleteBtn = document.createElement("button");
	deleteBtn.type = "button";
	deleteBtn.setAttribute("onclick", "deleteCategory(" + id + ");");
	deleteBtn.innerHTML = "Delete";
	div.append(deleteBtn);

	document.getElementById("categories").append(div);
	document.getElementById("new-cat").value = "";
}

/* AJAX code for categories */

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
			if (json.ok && parseInt(json.text) != 0)
				addCategoryRow(parseInt(json.text), document.forms["cat-manager"]["new-cat"].value);
			else
				alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}

function editCategory(id) {
	var fd = new FormData();
	fd.append("id", id);
	fd.append("name", document.forms["cat-manager"]["cat-" + id + "-name"].value);
	fetch("/admin/edit-category", {
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
			alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}

function deleteCategory(id) {
	var fd = new FormData();
	fd.append("id", id);
	fetch("/admin/delete-category", {
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
				document.getElementById("cat-" + id).remove();
			else
				alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}

/* AJAX code for boards */

function sendNewBoard() {
	var fd = new FormData();
	fd.append("handle", document.forms["board-manager"]["new-board-handle"].value);
	fd.append("name", document.forms["board-manager"]["new-board-name"].value);
	fd.append("category", document.forms["board-manager"]["new-board-category"].value);	
	fetch("/admin/add-board", {
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
				addBoardRow();
			else
				alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}

function editCategory(id) {
	var fd = new FormData();
	fd.append("id", id);
	fd.append("name", document.forms["cat-manager"]["cat-" + id + "-name"].value);
	fetch("/admin/edit-category", {
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
			alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}

function deleteCategory(id) {
	var fd = new FormData();
	fd.append("id", id);
	fetch("/admin/delete-category", {
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
				document.getElementById("cat-" + id).remove();
			else
				alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}