<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>${op.title} - ForEISTI</title>
		<link rel="stylesheet" href="/css/title.css">
		<link rel="stylesheet" href="/css/navbar.css">
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/board.css">
		<script src="/js/board.js"></script>
		<script src="/js/thread.js"></script>
		<script src="/js/navbarFunctions.js"></script>
		<link rel="icon" type="image/png" href="/img/foreisti.png">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	</head>

	<body>
		<jsp:include page="includes/navbar.jsp"/>
		<div class="base">
			<jsp:include page="includes/title.jsp"/>
			
			<div class="thread-base">
				<div class="op-title">${op.title}</div>
				<div class="op" id="p${op.id}">
					<div class="info-row">
						<div class="post-id">ID : ${op.id}&nbsp;&nbsp;</div>
						<div class="poster">From : ${op.poster.username}&nbsp;&nbsp;</div>
						<div class="timestamp">Date : ${op.timestamp}</div>
					</div>
					<div class="post-body">
						<c:if test="${op.picture != null}">
						<div class="img-container">
							<span>File: <a href="${op.picture.toString()}">${op.picture.originalName}</a></span>
							<c:choose>
							<c:when test='${op.picture.mimeType.split("/")[0] == "image"}'>
							<img src="${op.picture.toString()}" class="clickable smallsize-media" onclick="toggleEmbedSize(this);"/>
							</c:when>
							<c:otherwise>
							<span class="clickable" onclick="toggleEmbedSize(this);">[Expand]</span>
							<video src="${op.picture.toString()}" class="smallsize-media"></video>
							</c:otherwise>
							</c:choose>
						</div>
						</c:if>
					</div>
					<div class="post-text">
						<c:forTokens var="line" items="${op.text}" delims="
						">
						${line}<br/>
						</c:forTokens>
					</div>
					<c:if test="${user != null}">
					<div class="clickable" onclick="showThreadReplier(${op.id}, ${op.id})">Reply</div>
					</c:if>
				</div>

				<c:forEach var="r" items="${op.replies}">
				<div class="op" id="p${r.id}">
					<div class="info-row">
						<div class="post-id">ID : ${r.id}&nbsp;&nbsp;</div>
						<div class="poster">From : ${r.poster.username}&nbsp;&nbsp;</div>
						<div class="timestamp">Date : ${r.timestamp}</div>
					</div>
					<div class="post-body">
						<c:if test="${r.picture != null}">
						<div class="img-container">
							<span>File: <a href="${r.picture.toString()}">${r.picture.originalName}</a></span>
							<c:choose>
							<c:when test='${r.picture.mimeType.split("/")[0] == "image"}'>
							<img src="${r.picture.toString()}" class="clickable smallsize-media" onclick="toggleEmbedSize(this);"/>
							</c:when>
							<c:otherwise>
							<span class="clickable" onclick="toggleEmbedSize(this);">[Expand]</span>
							<video src="${r.picture.toString()}" class="smallsize-media"></video>
							</c:otherwise>
							</c:choose>
						</div>
						</c:if>
					</div>
					<div class="post-text">
						<c:forTokens var="line" items="${r.text}" delims="
						">
						${line}<br/>
						</c:forTokens>
					</div>
					<c:if test="${user != null}">
					<div class="clickable" onclick="showThreadReplier(${op.id}, ${r.id})">Reply</div>
					</c:if>
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
		</div>
	</body>
</html>
