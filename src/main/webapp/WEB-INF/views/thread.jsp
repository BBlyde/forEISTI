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
		<div class="op" id="p${op.id}">
			<div class="info-row">
				<span class="thread-title">${op.title}</span>
				<span class="poster">${op.poster.username}</span>
				<span class="timestamp">${op.timestamp}</span>
				<span class="clickable" onclick="showThreadReplier(${t.id}, ${t.id})">Reply</span>
			</div>
			<div class="post-text">${op.text}</div>
		</div>
		<c:forEach var="r" items="${op.replies}">
		<div class="reply" id="p${r.id}">
			<div class="info-row">
				<span class="poster">${r.poster.username}</span>
				<span class="timestamp">${r.timestamp}</span>
				<span class="clickable" onclick="showThreadReplier(${t.id}, ${t.id})">Reply</span>
			</div>
			<div class="post-text">${r.text}</div>
		</div>
		</c:forEach>
	</body>
</html>
