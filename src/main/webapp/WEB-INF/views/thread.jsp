<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>${op.title} - ForEISTI</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/board.css">
		<script src="/js/board.js"></script>
		<link rel="stylesheet" href="/css/navbar.css">
		<script src="/js/navbarFunctions.js"></script>
		<link rel="icon" type="image/png" href="">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	</head>

	<body>
		<div class="wrapper">
			<jsp:include page="includes/navbar.jsp"/>
			<div class="base">
	
				<div class="head">
					<a href="/"><img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"></a> 
					<p id ="foreisti">forEISTI</p>
				</div>
	
				<hr class="line">

				<div class="op-title">${op.title}</div>
	
				<div class="op" id="p${op.id}">
					<div class="info-row">
						<div class="post-id">Id : ${op.id}&nbsp;&nbsp;</div>
						<div class="poster">From : ${op.poster.username}&nbsp;&nbsp;</div>
						<div class="timestamp">Date : ${op.timestamp}</div>
					</div>
					<div class="post-text">${op.text}</div>
					<div class="clickable" onclick="showThreadReplier(${op.id}, ${op.id})">Reply</div>
				</div>

				<c:forEach var="r" items="${op.replies}">
				<div class="op" id="p${r.id}">
					<div class="info-row">
						<div class="post-id">Id : ${r.id}&nbsp;&nbsp;</div>
						<div class="poster">From : ${op.poster.username}&nbsp;&nbsp;</div>
						<div class="timestamp">Date : ${op.timestamp}</div>
					</div>
					<div class="post-text">${r.text}</div>
					<div class="clickable" onclick="showThreadReplier(${op.id}, ${r.id})">Reply</div>
				</div>
				</c:forEach>

				<form id="thread-replier" class="hidden creator" action="/${board.handle}/thread/id/reply" method="POST" enctype="multipart/form-data">
					<span id="tr-header" class="creator-header"></span>
					<div class="clickable creator-hider" onclick="hideThreadReplier()">X</div>
					<textarea id="tr-text" name="message" class="creator-text"></textarea>
					<input type="file" id="tr-file" name="file" class="creator-file"/>
					<input type="submit" class="creator-submit"∕>
				</form>
	
			</div>
	</body>
</html>
