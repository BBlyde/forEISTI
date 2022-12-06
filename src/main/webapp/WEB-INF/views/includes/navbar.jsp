<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="sidebar">
		<div class="sidebarTitle">
			<h2>forEISTI</h2>
		</div>
		<div class="sidebarCode">
			<c:choose>
			<c:when test="${user == null}">
			<p><i class="javaFunctionTest">if</i>(<span class=javaConstantText">userExists</span>)</p>
			<p><a href="/login">logIn();</a></p>
			<p><i class="javaFunctionText">else</i></p>
			<p><a href="/register">register();</a></p>
			</c:when>
			<c:otherwise>
			<p><a href="/logout">logOut();</a></p>
			</c:otherwise>
			</c:choose>
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
