<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="metier.M_Commande"%>
<%@page import="dao.M_DaoProduit"%>
<%@page import="metier.M_Produit"%>

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
	<input type="text" name="prenom" id="mdp" readonly="readonly" value="<%out.println(prenom);%>"></input>
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
