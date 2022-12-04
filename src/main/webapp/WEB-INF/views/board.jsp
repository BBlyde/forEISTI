<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>/${board.handle}/ - ${board.name} - ForEISTI</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/board.css">
		<link rel="icon" type="image/png" href="">
		<script src="/js/board.js"></script>
	</head>

	<body>
		<div class="base">

			<div class="head">
				<img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">

			<div class="title">
				Welcome to the <p class="boardname">&nbsp;/${board.handle}/ - ${board.name}&nbsp;</p> Board
			</div>
	
			<hr class="line">
	
			<div class="description">
				Quick desc
				${board.description}
			</div>
	
			<hr class="line">

			<c:choose>
			<c:when test="${user == null}">
			<div>You must be logged in to create or reply to a thread</div>
			</c:when>
			<c:otherwise>
			<div class="clickable" onclick="showThreadCreator()">Create a thread</div>
			</c:otherwise>
			</c:choose>

			<hr class="line">
	
			<div class="thread">
				Thread inc
				<c:forEach var="t" items="threads">
				</c:forEach>
			</div>
	
			<form id="thread-creator" class="hidden creator" action="/${board.handle}/create-thread" method="POST" enctype="multipart/form-data">
				<div class="clickable creator-hider" onclick="hideThreadCreator()">Hide</div>
				<input type="text" id="nt-title" name="title" placeholder="Thread title"/>
				<textarea name="message"></textarea>
				<input type="file" id="nt-file" name="file"/>
				<input type="submit"∕>
			</form>

		</div>
	</body>
</html>
