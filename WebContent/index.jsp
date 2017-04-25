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
			<%@include file="/view/templates/header.jsp" %>
		</header>
		<nav>
		<%@include file="/view/templates/menu.jsp" %>
		</nav>
		<section>
			<h1>Bienvenido a nuestra panadería !</h1>
			<img src="images/panierApain.PNG" height="350px" width="550px" /> 
		</section>
		<footer>
			<%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>