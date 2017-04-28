<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="metier.M_Commande"%>
<%@page import="dao.M_DaoProduit"%>
<%@page import="metier.M_Produit"%>
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
		<%
		 	String nom = (String) request.getAttribute("nom");
		
		 	String prenom = (String) request.getAttribute("prenom");
		
		 	String mail = (String) request.getAttribute("mail");
		
		 	String login = (String) request.getAttribute("login");
		
		 	String tel = (String) request.getAttribute("tel");
		 %>

		<h1 style="color: green;">Registro finalizada</h1>

		<h2>Resumen de los datos personales</h2>

		<fieldset>
			<legend>Tus datos</legend>
			<label for="nom">Appellido :</label> 
			<input type="text" name="nom" id="nom" readonly="readonly" value="<%out.println(nom);%>"></input>
			<br /> 
			<label for="prenom">Nombre :</label> 
			<input type="prenom" name="prenom" id="mdp" readonly="readonly" value="<%out.println(prenom);%>"></input>
			<br />
			<label for="mail">Mail :</label> 
			<input type="text" name="mail"	id="mail" readonly="readonly" value="<%out.println(mail);%>"></input>
			<br />
			<label for="tel">Tel :</label>
			<input type="text" name="tel" id="tel"	readonly="readonly" value="<%out.println(tel);%>"></input>
			<br />
		</fieldset>

		<fieldset>
			<legend>ID de inicio de sesión</legend>
			<label for="login">Login :</label> 
			<input type="text"	readonly="readonly" name="login" id="login"	value="<%out.println(login);%>"></input>
			<br />
		</fieldset>

		<br />
		<input type="button" value="Retour à l'accueil" onclick="history.go(-1)"> <br />
		</section>
		<footer> <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>