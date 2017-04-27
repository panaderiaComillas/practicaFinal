<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="metier.M_Menu"%>
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
		<h1 style="color: red;">Ordenar</h1>
		<fieldset>
			<legend>Finalización</legend>
			<br />
			<p style="text-align: center; font-size:18px; color:green;">Orden almacenada !
			</p>
			<br/>
			<label>Detalles :</label>
			<br/><br/>
			<p style="text-align: center;">
				Menu : 
				<%
					out.println(request.getAttribute("nomMenu"));
				%>
				<br/><hr>
				Ingredientes : 
				<%
					String[] ingrédients = (String[])request.getAttribute("ingrédients");
					for (int i = 0; i < ingrédients.length; i++) {
						out.println(ingrédients[i]);
					}
					out.println(request.getAttribute("ingrédients"));
				%>
				<br/><hr>
				Salsas : 
				<%					
					out.println(request.getAttribute("ingrédients"));
				%>
				<br/><hr>
				Bebida : 
				<%
					out.println(request.getAttribute("boisson"));
				%>
				<br/><hr>
				Postre : 
				<%
					out.println(request.getAttribute("dessert"));
				%>
				<br/><hr>
				Retirada : 
				<%
					out.println(request.getAttribute("typeRetrait"));
				%>
			</p>
		</fieldset>
		</section>
		<footer> <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>