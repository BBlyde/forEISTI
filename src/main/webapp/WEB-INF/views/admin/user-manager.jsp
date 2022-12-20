<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Admin panel</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/admin.css">
		<link rel="icon" type="image/png" href="">
		<script src="/js/adminPanel.js"></script>
	</head>
	<body>

		<div class="base">

			<div class="head">
				<a href="/"><img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"></a> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">

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
