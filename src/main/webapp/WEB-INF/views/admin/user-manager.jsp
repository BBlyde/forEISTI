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
                <p class="title-categories">Users</p>

                <form id="cat-manager">
                    <div id="categories">
                        <c:forEach var="u" items="${users}">
                        <div id="cat-${u.username}">
                            ${u.username}
                            <button type="button" onclick="deleteUser('${u.username}')" class="category-delete">Delete</button>
                        </div>
                        </c:forEach>
                    </div>
                </form>
			</div>

            
			
		</div>
		
	</body>
</html>
