<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Sign up for ForEisti</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/title.css">
		<link rel="icon" type="image/png" href="/img/foreisti.png">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	</head>

	<body>
		<div class="base">
			<main>
				<jsp:include page="includes/title.jsp"/>
			
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
			</main>
			<jsp:include page="includes/footer.jsp"/>
		</div>
	</body>
</html>
