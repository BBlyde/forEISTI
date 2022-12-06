<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="sidebar">
		<div class="sidebarTitle">
			<h2>forEISTI</h2>
		</div>
		<div class="sidebarCode">
			<div class="ifstatement">
				<c:choose>
					<c:when test="${user == null}">
						<p><i class="javaFunctionText">if</i>(<a href="#" class=javaConstantText">userExist</a>){</p>
						<div class="ifcase">	
							<p><a href="/login" class="javaConstantText">logIn</a>( );</p>
						</div>
						<p>} <i class="javaFunctionText">else</i>{</p>
						<div class="ifcase">
							<p><a href="/register"><i class="javaFunctionText">new</i> <i class="javaConstantText">User</i></a>( );</p>
						</div>
						<p>}</p>
					</c:when>
					<c:otherwise>
						<p><i class="javaFunctionText">if</i>(<a href="#" class=javaConstantText">loggedIn</a>){</p>
							<div class="ifcase">	
								<p><a href="/logout">logOut();</a></p>
							</div>
							<p>}</p>
						
					</c:otherwise>
				</c:choose>
			</div>
		</div>	
		<div class="sidebarCode">	
			<div class="forloop">
				<p><i class="javaFunctionText">for</i>(<i class="javaTypeText">String</i> category : <a href="#" class="javaConstantText">EISTI</a>){</p>
				<div class="switch">
					<p><i class="javaFunctionText">switch</i>(category){</p>
						<c:forEach var="cat" items="${categories}">
						<div id="${cat.name}" class="switchcase">
							<div class="switch-case-condition">
								<p><i class="javaFunctionText">case</i> <span onclick="displayCategory(this)" class="javaStringText">"${cat.name}"</span> : </p>
								<span class="material-symbols-outlined minimise">chevron_right</span><span class="material-symbols-outlined dropdown">expand_more</span>
							</div>
							<div class="switch-case-elements">
								<ul>
									<c:forEach var="brd" items="${cat.boards}">
										<li class='board'><a href=${brd.handle}>${brd.name}</a></li>
									</c:forEach>
								</ul>
								<p><i class="javaFunctionText">break</i>;</p>
							</div>
						</div>
						</c:forEach>
					<p> }</p>
				</div>
				<p>}</p>
			</div>
		</div>
	</div>
</header>