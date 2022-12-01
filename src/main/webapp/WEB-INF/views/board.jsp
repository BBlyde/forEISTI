<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>/${board.handle}/ - ${board.name} - ForEISTI</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="icon" type="image/png" href="">
		<script src="/js/adminPanel.js"></script>
	</head>

	<body>
		<h1>/${board.handle}/ - ${board.name}</h1>
		<c:forEach var="t" items="threads">
		<%//thread div%>
		</c:forEach>
	</body>
</html>
