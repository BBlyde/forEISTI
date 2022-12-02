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

		<div class="base">
			<div class="head">
				<img class="homelogo" src="/img/foreisti.png" alt="forEISTI logo"> 
				<p id ="foreisti">forEISTI</p>
			</div>

			<hr class="line">
	
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
				<p id="boardtitle">Boards</p>
				<div class="boardtab">
					testing stuff
				</div>
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

			<!--not working for now-->
			<%/*<c:forEach var="c" items="category">
				${c.name}
				<c:forEach var="b" items="board">
					${b.name}
				</c:forEach>
			</c:forEach>*/%>

		</div>		
	</body>
</html>
