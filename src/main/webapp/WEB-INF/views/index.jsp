<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>forEISTI</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="icon" type="image/png" href="">
	</head>
	<body>
		<c:if test="${userCreationStatus}">
		<div>Account successfully created!</div>
		</c:if>
		Welcome to ForEisti!
		<br/>
		widepeepoHappy
		<c:if test="${sessionScope.username != null}">
			Welcome ${sessionScope.username}
		</c:if>
	</body>
</html>
