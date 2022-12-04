/* DOM code */

function addCategoryRow(id, catName) {
	var div = document.createElement("div");
	div.id = "cat-" + id;

	var nameField = document.createElement("input");
	nameField.id = "cat-" + id + "-name";
	nameField.type = "text";
	nameField.value = catName;
	nameField.placeholder = "Category name";
	nameField.className = "category-list-name"
	div.appendChild(nameField);

	var editBtn = document.createElement("button");
	editBtn.type = "button";
	editBtn.setAttribute("onclick", "editCategory(" + id + ");");
	editBtn.innerHTML = "Rename";
	editBtn.className = "category-rename";
	div.appendChild(editBtn);

	var deleteBtn = document.createElement("button");
	deleteBtn.type = "button";
	deleteBtn.setAttribute("onclick", "deleteCategory(" + id + ");");
	deleteBtn.innerHTML = "Delete";
	deleteBtn.className = "category-delete";
	div.appendChild(deleteBtn);

	document.getElementById("categories").append(div);
	document.getElementById("new-cat").value = "";

	var opt = document.createElement("option");
	opt.id = "cat-option-" + id;
	opt.value = id;
	opt.innerHTML = catName;
	document.getElementById("category-list").appendChild(opt);
}

function addBoardRow(handle) {
	var newRow = document.createElement("tr");
	newRow.id = handle;
	for (let col of ["-name", "-handle", "-category"]) {
		var td = document.createElement("td");
		var input = document.createElement("input");
		input.id = handle + col;
		input.value = document.getElementById("new-board" + col).value;
		input.className = "case";
		td.appendChild(input);
		newRow.appendChild(td);
		document.getElementById("new-board" + col).value = "";
	}
	var td = document.createElement("td");
	var editBtn = document.createElement("button");
	editBtn.type = "button";
	editBtn.className = "input-board";
	editBtn.setAttribute("onclick", "editBoard(\"" + handle + "\")");
	editBtn.innerHTML = "Edit";
	td.appendChild(editBtn);

	var deleteBtn = document.createElement("button");
	deleteBtn.type = "button";
	deleteBtn.className = "input-board input-board-delete"
	deleteBtn.setAttribute("onclick", "deleteBoard(\"" + handle + "\")");
	deleteBtn.innerHTML = "Delete";
	td.appendChild(deleteBtn);

	newRow.appendChild(td);
	document.getElementById("boards").appendChild(newRow);
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
			var json = JSON.parse(content);
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
			var json = JSON.parse(content);
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
			var json = JSON.parse(content);
			if (json.ok) {
				document.getElementById("cat-" + id).remove();
				document.getElementById("cat-option-" + id).remove();
			}
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
			var json = JSON.parse(content);
			if (json.ok)
				addBoardRow(document.forms["board-manager"]["new-board-handle"].value);
			else
				alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}

function editBoard(handle) {
	var fd = new FormData();
	var nameInput = document.forms["board-manager"][handle + "-name"];
	var handleInput = document.forms["board-manager"][handle + "-handle"];
	var categoryInput = document.forms["board-manager"][handle + "-category"];
	fd.append("oldHandle", handle);
	fd.append("newHandle", handleInput.value);
	fd.append("name", nameInput.value);
	fd.append("category", categoryInput.value);	
	fetch("/admin/edit-board", {
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
			var json = JSON.parse(content);
			if (json.ok) {
				nameInput.id = handle + "-name";
				handleInput.id = handle + "-handle";
				categoryInput.id = handle + "-category";
			}
			alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}

function deleteBoard(handle) {
	var fd = new FormData();
	fd.append("handle", handle);
	fetch("/admin/delete-board", {
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
			var json = JSON.parse(content);
			if (json.ok)
				document.getElementById(handle).remove();
			else
				alert(json.text);
		} catch (err) {
			console.log(err);
		}
	});
}
