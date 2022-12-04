<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Admin panel</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/board.css">
		<link rel="icon" type="image/png" href="">
		<script src="/js/adminPanel.js"></script>
	</head>
	<body>

		<div class="base">

			<div class="head">
				<img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">

			<div class="board-manager-box">
				<p class="title-categories">Categories</p>
				<datalist id="category-list">
					<c:forEach var="c" items="${categories}">
					<option id="cat-option-${c.id}" value="${c.id}">${c.name}</option>
					</c:forEach>
				</datalist>

				<form id="cat-manager">
					<div id="categories">
						<c:forEach var="c" items="${categories}">
						<div id="cat-${c.id}">
							<input id="cat-${c.id}-name" type="text" value="${c.name}" placeholder="Category name" class="category-list-name"/>
							<button type="button" onclick="editCategory(${c.id})" class="category-rename">Rename</button>
							<button type="button" onclick="deleteCategory(${c.id})" class="category-delete">Delete</button>
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
						<thead><tr><th>Board name</th><th>Handle</th><th>Category ID</th></tr></thead>
						<tbody id="boards">
							<c:forEach var="b" items="${boards}">
							<tr id="${b.handle}">
								<td><input type="text" value="${b.name}" id="${b.handle}-name"/></td>
								<td><input type="text" value="${b.handle}" id="${b.handle}-handle"/></td>
								<td><input list="category-list" value="${b.category.id}" id="${b.handle}-category"/></td>
								<td><button type="button" onclick="editBoard('${b.handle}')">Edit</button><button type="button" onclick="deleteBoard('${b.handle}')">Delete</button></td>
							</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr id="new-board">
								<td><input type="text" placeholder="Name" id="new-board-name"/></td>
								<td><input type="text" placeholder="Handle" id="new-board-handle"/></td>
								<td><input list="category-list" placeholder="Category (will be replaced by id)" id="new-board-category"/></td>
								<td><button type="button" onclick="sendNewBoard()"/>Add new board</button></td>
							</tr>
						</tfoot>
					</table>
				</form>

			</div>
			
		</div>
		
	</body>
</html>
