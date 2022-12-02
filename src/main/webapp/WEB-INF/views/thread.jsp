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
		<div class="thread">
			${op.poster.username} - ${op.timestamp}<br>
			${op.title}<br><br>
			${op.text}
		</div>
	</body>
</html>
