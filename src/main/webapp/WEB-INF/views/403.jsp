<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Forbidden</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/error.css">
		<link rel="icon" type="image/png" href="/img/foreisti.png">
		<link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@600;900&display=swap" rel="stylesheet">
  		<script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
	<body>
		<div class="base">
			<div class="head">
				<a href="/"><img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"></a> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">

			<div class="mainbox">
				<div class="err">4</div>
				<i class="far fa-question-circle fa-spin"></i>
				<div class="err2">3</div>
				<div class="msg">Not authorised,&nbsp;<a href="/" class="back">go back to main page</a></div>
			</div>
		</div>
	</body>
</html>
