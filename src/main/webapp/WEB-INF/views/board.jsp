<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>/${board.handle}/ - ${board.name} - ForEISTI</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/board.css">
		<link rel="icon" type="image/png" href="/img/foreisti.png">
		<script src="/js/board.js"></script>
	</head>

	<body>
		<div class="base">

			<div class="head">
				<a href="/"><img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"></a> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">

			<div class="title">
				Welcome to the <p class="boardname">&nbsp;/${board.handle}/ - ${board.name}&nbsp;</p> Board
			</div>
	
			<hr class="line">
	
			<div class="description">
				<div class="description-title">Description</div>
				<div class="description-content">${board.description}</div>
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
	
			<c:forEach var="t" items="${threads}">
			<div class="thread" id="t${t.id}">
				<div class="op">
					<div class="info-row">
						<span class="thread-title">${t.title}</span>
						<span class="poster">${t.poster.username}</span>
						<span class="timestamp">${t.timestamp}</span>
						<span class="clickable" onclick="showThreadReplier(${t.id}, ${t.id})">Reply</span>
					</div>
					<div class="post-text">${t.text}</div>
				</div>
			</div>
			</c:forEach>
	
			<form id="thread-creator" class="hidden creator" action="/{$board.handle}/create-thread" method="POST" enctype="multipart/form-data">
				<span id="nt-header">Create a new thread</span>
				<div class="clickable creator-hider" onclick="hideThreadCreator()">Hide</div>
				<input type="text" id="nt-title" name="title" placeholder="Thread title"/>
				<textarea id="nt-text" name="message"></textarea>
				<input type="file" id="nt-file" name="file"/>
				<input type="submit"∕>
			</form>
			<form id="thread-replier" class="hidden creator" action="/${board.handle}/thread/id/reply" method="POST" enctype="multipart/form-data">
				<span id="tr-header"></span>
				<div class="clickable creator-hider" onclick="hideThreadReplier()">Hide</div>
				<textarea id="tr-text" name="message"></textarea>
				<input type="file" id="nt-file" name="file"/>
				<input type="submit"∕>
			</form>

		</div>
	</body>
</html>
