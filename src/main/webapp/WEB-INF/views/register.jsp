<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Sign up for ForEisti</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="icon" type="image/png" href="">
	</head>

	<body>
		<div class="base">

			<div class="head">
				<img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">
			
			<c:if test="${error != null}">
				${error}
			</c:if>

			<form action="/register" method="post" class="connection">
				<p class="connectiontitle">Registration</p>

				<label for="username">
					<input type="text" name="username" id="username" placeholder="Username"/>
				</label>
				<label for="password">
					<input type="password" name="password" id="password" placeholder="Password"/>
				</label>
				<input type="submit" value="Register" id="submit"/>

				<p id="redirect"><a href="login">Already have an Account?</a></p>
			</form>

		</div>
	</body>
</html>
