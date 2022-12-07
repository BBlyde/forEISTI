<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>${op.title} - ForEISTI</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="icon" type="image/png" href="">
	</head>

	<body>
		<div class="base">

			<div class="head">
				<a href="/"><img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"></a> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">

			<div class="op" id="p${op.id}">
				<div class="info-row">
					<div class="thread-title">${op.title}</div>
					<div class="poster">${op.poster.username}</div>
					<div class="timestamp">${op.timestamp}</div>
					<div class="clickable" onclick="showThreadReplier(${t.id}, ${t.id})">Reply</div>
				</div>
				<div class="post-text">${op.text}</div>
			</div>
			<c:forEach var="r" items="${op.replies}">
			<div class="reply" id="p${r.id}">
				<div class="info-row">
					<div class="poster">${r.poster.username}</div>
					<div class="timestamp">${r.timestamp}</div>
					<div class="clickable" onclick="showThreadReplier(${t.id}, ${t.id})">Reply</div>
				</div>
				<div class="post-text">${r.text}</div>
			</div>
			</c:forEach>

		</div>
	</body>
</html>
