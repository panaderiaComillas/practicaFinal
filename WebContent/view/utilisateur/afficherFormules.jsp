<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List" %>
<%@page import="metier.M_Menu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La Cesta de Pan</title>
</head>
<body>
	<div id="global">
		<header> <%@include file="/view/templates/header.jsp"%>
		</header>
		<nav> <%@include file="/view/templates/menu.jsp"%>
		</nav>
		<section>
			<h1 style="color: red;">Formules du Midi</h1>
			<%
				List<M_Menu> listFormules= (List<M_Menu>)request.getAttribute("listFormules");
				for (M_Menu uneFormule: listFormules) {
					System.out.println("<div style='font-size:17px;'>"+ "- "+uneFormule.getNomMenu() + " : " + uneFormule.getPrixMenu() + " €<div>");
		            System.out.println("<br/>");
		        }
			%> 
		</section>
		<footer> <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>