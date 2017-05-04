<script language="JavaScript" type="text/javascript" src="fonctionsJavascript.inc.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="metier.M_Menu"%>

<%
List<M_Menu> listFormules = (List<M_Menu>) request.getAttribute("listFormules");
%>

<form method="post"	action="${pageContext.request.contextPath}/C_Commander2">
	<h1 style="color: red;">Ordenar</h1>
	<fieldset>
		<legend>Menu</legend>
		<p>
		Elija su menú :
		<br />
		<br />
		<%
		for (M_Menu uneFormule: listFormules) {
		%>
			<input style="float: none ;" type="radio" name="menus" value="<%=uneFormule.getNomMenu()%>" 
			id="menu<%=uneFormule.getIdMenu()%>" required/>
			<label style="float: none ;" for="menu<%=uneFormule.getIdMenu()%>">
			<%=uneFormule.getNomMenu()%> : <%=uneFormule.getPrixMenu()%> €
			</label>
			
            <br/>
		<% } %>
		</p>
		<div id="erreur"
			style="text-align: center; color: red; display: none;">
			Veuillez choisir un menu !</div>
		<p style="text-align: center;">
			<input style="float: none; margin-bottom: 0;" type="submit" value="Validar" />
		</p>
	</fieldset>
</form>
