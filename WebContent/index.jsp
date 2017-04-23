<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La Cesta de Pan</title>
</head>
<body>
	<div id="global">
		<header>
			<%@include file="view/templates/header.jsp" %>
		</header>
		<nav>
		<div id="gauche">
			<ul class="menugauche">
				<p>
				<h2>Navegación</h2>
				</p>
				<p class="note">
				<li><a href="">Página Principal</a></li>
				<hr />
				<li><a href="view/registrarse.jsp">Registrarse</a></li>
				<br>
				<li><a href="view/conectarse.jsp">Conectarse</a></li>
				<hr />
				<li><a href="view/misInformaciones.jsp">Mis Informaciones</a></li>
				<br>
				<li><a href="view/misPedidos.jsp">Mis Pedidos</a></li>
				<hr />
				<li><a href="view/formulas.jsp">Nuestras Fórmulas</a></li>
				<br>
				<li><a href="view/productos.jsp">Nuestros Productos</a></li>
				<hr />
				<li><a href="view/ordenar.jsp">Ordenar</a></li>
			</ul>
		</div>
		</nav>
		<section>
			<h1>Bienvenido a nuestra panadería !</h1>
			<img src="images/panierApain.PNG" height="350px" width="550px" /> 
		</section>
		<footer>
			<%@include file="view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>