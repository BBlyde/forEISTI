<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Admin panel</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="icon" type="image/png" href="">
		<script src="/js/adminPanel.js"></script>
	</head>
	<body>
		<h1>Categories</h1>
		<form id="cat-manager">
			<div id="categories">
				<c:forEach var="c" items="${categories}">
				<div id="cat-${c.id}">
					<input id="cat-${c.id}-name" type="text" value="${c.name}" placeholder="Category name"/>
					<button type="button" onclick="editCategory(${c.id})">Rename</button>
					<button type="button" onclick="deleteCategory(${c.id})">Delete</button>
				</div>
				</c:forEach>
			</div>
			<label for="new-cat">
				New category: <input type="text" id="new-cat" name="new" placeholder="New category"/>
			</label>
			<button type="button" onclick="sendNewCategory()">Create</button>
		</form>
		<h1>Boards</h1>
		<form id="board-manager">
			<table>
				<thead><tr><th>Board name</th><th>Handle</th><th>Category</th></tr></thead>
				<tbody id="boards">
					<c:forEach var="b" items="${boards}">
					<tr id="${b.handle}">
						<td><input type="text" value="${b.name}"/></td>
						<td><input type="text" value="${b.handle}"/></td>
						<td><input type="text" value="${b.category}"/></td>
						<td><button type="button" onclick="editBoard(${b.handle})">Edit</button><button type="button" onclick="deleteBoard(${b.handle})">Delete</button></td>
					</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr id="new-board">
						<td><input type="text" placeholder="Name"/></td>
						<td><input type="text" placeholder="Handle"/></td>
						<td><input type="text"/></td>
						<td><button type="button" onclick="addBoard()"/></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
