<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>forEISTI</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/navbar.css">
		<script src="/js/navbarFunctions.js"></script>
		<link rel="icon" type="image/png" href="/img/foreisti.png">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp"/>

		<div class="base">
			<div class="head">
				<a href="/"><img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"></a> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">

			<c:if test="${userCreationStatus}">
			<p>Account successfully created!</p>
			<p>Welcome, ${user.username}!</p>
			</c:if>
			<c:if test="${logoutStatus != null}">
			<p>${logoutStatus}</p>
			</c:if>

	
			<div class="desc">
				<p id="what">What is forEISTI?</p>
				<p id="d">
					Aliquam tempor ipsum id velit tristique, vitae interdum tortor scelerisque.
					In semper ligula odio, sit amet ullamcorper quam aliquet venenatis.
					Integer ac est est. Fusce risus justo, hendrerit a libero vel, feugiat suscipit urna.
					Morbi urna dui, posuere vel egestas vel, sollicitudin a eros.
					Suspendisse at velit euismod, feugiat risus eget, posuere dolor.
					Nunc congue leo et felis lobortis pretium. Donec gravida leo a leo pharetra vehicula.
					Sed vestibulum dictum ipsum, ut consectetur augue maximus ut.
					Etiam est mauris, auctor sit amet metus eu, varius pharetra massa.
					Cras suscipit tellus et maximus scelerisque.
					Donec augue nunc, ultricies vel elit et, efficitur vulputate erat.
					Interdum et malesuada fames ac ante ipsum primis in faucibus.
					Sed blandit diam in mi tincidunt, sit amet commodo risus finibus.
					Integer ut ipsum ac sem efficitur condimentum. 
				</p>
			</div>

			<hr class="line">
			
			<div class="menu">
				<p id="board-title">Boards</p>
				<c:forEach var="cat" items="${categories}">
					<div class="cat-list">
						<div class="board-tab">${cat.name}</div>
						<c:forEach var="board" items="${cat.boards}">
							<a href=${board.handle}><div class="board-list">${board.name}</div></a>
						</c:forEach>
					</div>
				</c:forEach>
			</div>

			<hr class="line">

			<div class="stats">
				<p id="statstitle">Stats</p>
				<div class="boardtab">

					<div class="statsrow">
						<p class="statsname">Total Posts: yes</p>
						<p class="statsname">Current Users: no</p>
					</div>
				</div>
			</div>

			<c:forEach var="entry" items="${categoryMap}">
			${entry.key.name} <%//Category (map key) name%>
			<c:forEach var="b" items="${entry.value}">
			${b.name}
			</c:forEach>
			</c:forEach>

			<hr class="line">

			<div class="footer">
				Copyright © 2022 forEISTI community support LLC. All rights reserved.
			</div>

		</div>		
	</body>
</html>
