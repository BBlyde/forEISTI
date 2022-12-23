<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Admin panel</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/admin.css">
		<link rel="stylesheet" href="/css/title.css">
		<link rel="stylesheet" href="/css/navbar.css">
		<link rel="icon" type="image/png" href="">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
		<script src="/js/adminPanel.js"></script>
		<script src="/js/navbarFunctions.js"></script>
	</head>
	<body>
		<jsp:include page="../includes/navbar.jsp"/>
		<div class="base">
			<jsp:include page="../includes/title.jsp"/>

			<div class="board-manager-box">
				<p class="title-categories">Categories</p>

				<form id="cat-manager" class="group-manager">
					<div id="categories">
						<c:forEach var="c" items="${categories}">
						<div id="cat-${c.id}">
							<input id="cat-${c.id}-name" type="text" value="${c.name}" placeholder="Category name" class="category-list-name"/>
							<button type="button" onclick="editCategory(${c.id})" class="category-button">Rename</button>
							<button type="button" onclick="deleteCategory(${c.id})" class="category-button">Delete</button>
						</div>
						</c:forEach>
					</div>
					<label for="new-cat">
						<p class="new-cat">New category: </p><input type="text" id="new-cat" name="new" placeholder="New category" class="category-list-name"/>
					</label>
					<button type="button" onclick="sendNewCategory()" class="create-cat">Create</button>
				</form>

				<p class="title-categories">Boards</p>
				<form id="board-manager" class="group-manager">
					<table>
						<div class="cats-name"><thead><tr><th>Board name</th><th>Handle</th><th>Description</th><th>Categories</th></tr></thead></div>
						<tbody id="boards">
							<c:forEach var="b" items="${boards}">
							<tr id="${b.handle}">
								<td><input type="text" value="${b.name}" id="${b.handle}-name" class="case"/></td>
								<td><input type="text" value="${b.handle}" id="${b.handle}-handle" class="case"/></td>
								<td><textarea id="${b.handle}-desc" class="case">${b.description}</textarea></td>
								<td><input type="hidden" value="${b.categoryIdList()}" id="${b.handle}-categories"/><button type="button" class="input-board input-board-set" onclick="showCategoryMenu('${b.handle}');">Set</button></td>
								<td><button type="button" onclick="editBoard('${b.handle}')" class="input-board">Edit</button><button type="button" onclick="deleteBoard('${b.handle}')" class="input-board input-board-delete">Delete</button></td>
							</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr id="new-board">
								<td><input type="text" placeholder="Name" id="new-board-name" class="case"/></td>
								<td><input type="text" placeholder="Handle" id="new-board-handle" class="case"/></td>
								<td><textarea id="new-board-desc" class="case"></textarea></td>
								<td><input type="hidden" id="new-board-categories" value="[]"/><button type="button" class="input-board input-board-set" onclick="showCategoryMenu('new-board');">Set</button></td>
								<td><button type="button" onclick="sendNewBoard()"class="input-new-board"/>Add new board</button></td>
							</tr>
						</tfoot>
					</table>
					<div id="category-menu" class="hidden">
						<div>
							<span id="cat-menu-header"></span>
							<div id="cat-menu-checkboxes">
								<c:forEach var="c" items="${categories}">
								<label for="cat-option-${c.id}"><input type="checkbox" id="cat-option-${c.id}" value="${c.id}"/><span class="category-setter-name">${c.name}</span></label>
								</c:forEach>
							</div>
							<button type="button" onclick="hideCategoryMenu();" class="category-setter-button">Cancel</button>
							<button type="button" id="category-validate" class="category-setter-button">OK</button>
						</div>
					</div>
				</form>

			</div>
			
		</div>
		
	</body>
</html>
