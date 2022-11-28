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
		<form id="cat-manager" action="admin/add-category" method="post">
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
	</body>
</html>
