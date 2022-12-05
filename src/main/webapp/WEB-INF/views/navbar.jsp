<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Navbar</title>
		<link rel="stylesheet" href="/css/navbar.css">
		<script src="/js/navbarFunctions.js"></script>
	</head>
	<body>
		<header>
			<div class="sidebar">
				<div class="sidebarTitle">
					<h2>For_EISTI</h2>
				</div>
				<div class="sidebarCode">
					<div class="forloop">
						<p><i class="javaFunctionText">for</i>(<i class="javaTypeText">String</i> category : <a href="#" class="javaConstantText">EISTI</a>){</p>
						<div class="switch">
							<p><i class="javaFunctionText">switch</i>(category){</p>
							<div class="switchcase">
								<c:forEach var="cat" items="${categories}">
								<p><i class="javaFunctionText">case</i> <span onclick="displayCategory(this,${cat.name})" class="javaStringText clickable">"${cat.name}"</span> :</p>
									<div id="${cat.name}" class="switch-case-elements">
        									<ul>
											<c:forEach var="brd" items="${cat.boards}">
												<li class='board'><a href=${brd.handle}>${brd.name}</a></li>
											</c:forEach>
										</ul>
										<p><i class="javaFunctionText">break</i>;</p>
									</div>	
								</c:forEach>
							</div>
							<p>}</p>
						</div>
						<p>}</p>
					</div>
    				</div>
			</div>
		</header>
	</body>
</html>
