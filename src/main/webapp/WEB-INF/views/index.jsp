<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>forEISTI</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/title.css">
		<link rel="stylesheet" href="/css/navbar.css">
		<script src="/js/navbarFunctions.js"></script>
		<link rel="icon" type="image/png" href="/img/foreisti.png">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp"/>
		<div class="base">
			<main>
				<jsp:include page="includes/title.jsp"/>
				<c:if test="${userCreationStatus}">
					<p>Account successfully created!</p>
					<p>Welcome, ${user.username}!</p>
				</c:if>
				<c:if test="${logoutStatus != null}">
					<p>${logoutStatus}</p>
				</c:if>

				<div class="desc bloc">
					<p class="bloc-subtitle">What is this?</p>
					<div class="descriptionbox">
						<p class="text-desc">
							ForEISTI is a simple forum based for former and current students of CY-Tech (ex-EISTI). There are boards dedicated to a variety of topics, from Japanese animation and culture to video games. 
							Users do not need to register an account to read threads but will have to if they wish to participate in the community. Feel free to click on a board below that interests you and jump right in!
						</p>
					</div>
				</div>

				<hr class="line">

				<div class="menu bloc">
					<p class="bloc-subtitle">Boards</p>
					<div class="content-menu">
						<c:forEach var="cat" items="${categories}">
							<div class="cat-list">
								<div class="cat-title">
									<span class="board-cat">${cat.name}</span>
								</div>
								<div class="cat-boards">
									<c:forEach var="board" items="${cat.boards}">
										<a href=/${board.handle}>
											<div class="board-list">${board.name}</div>
										</a>
									</c:forEach>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<hr class="line">

				<div class="stats bloc">
					<p class="bloc-subtitle">Stats</p>
					<div class="boardtab">
						<div class="statsrow">
							<p class="statsname">Total Threads: ${threadCount}</p>
							<p class="statsname">Current Users: ${userCount}</p>
						</div>
					</div>
				</div>

			</main>
			<jsp:include page="includes/footer.jsp"/>
		</div>
	</body>
</html>
