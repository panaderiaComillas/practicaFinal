<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List" %>
<%@page import="metier.M_Sandwich" %>
<%@page import="metier.M_Ingredient" %>
<%@page import="metier.M_Dessert" %>
<%@page import="metier.M_Boisson" %>
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
		<ul id="menu">
			<li class="onglet_1"><a id="boutonSandwich">Sandwichs</a></li>
			<li class="onglet_2"><a id="boutonBoisson">Boissons</a></li>
			<li class="onglet_3"><a id="boutonDessert">Desserts</a></li>
		</ul>

		<div id="divSandwich" style="display: block">
			<br>
			<table border="1px"
				style="display: inline-block; vertical-align: top;">
				<tr>
					<th>Sandwichs</th>
				</tr>
				<%
				List<M_Sandwich> listSandwichs= (List<M_Sandwich>)request.getAttribute("listSandwichs");
				for (M_Sandwich unSandwich: listSandwichs) {
					System.out.println("<tr>");
					System.out.println("<td>"+unSandwich.getNomProduit());
		            if(!unSandwich.isTemperaturePain()){
		            	System.out.println(" froid</td>");
		            }  
		            else if(unSandwich.isTemperaturePain())
		            {
		            	System.out.println(" chaud</td>");
		            }
		            System.out.println("</tr>");
		        }
				%>
			</table>
			<table border="1px"
				style="display: inline-block; vertical-align: top;">
				<tr>
					<th>Ingrédients</th>
				</tr>
				<%
				List<M_Ingredient> listIngredients= (List<M_Ingredient>)request.getAttribute("listIngredients");
				for (M_Ingredient unIngredient: listIngredients) {
					System.out.println("<tr>");
					System.out.println("<td>"+unIngredient.getNomIngredient()+"</td>");
		            System.out.println("</tr>");
		        }
				%>
			</table>
			<img src="../vues/images/americain.jpg" height="240px" width="360px"
				style="float: right" />
		</div>

		<div id="divDessert" style="display: none">
			<br>
			<table border="1px"
				style="display: inline-block; vertical-align: top;">
				<tr>
					<th>Desserts</th>
				</tr>
				<%
				List<M_Dessert> listDesserts= (List<M_Dessert>)request.getAttribute("listDesserts");
				for (M_Dessert unDessert: listDesserts) {
					System.out.println("<tr>");
					System.out.println("<td>"+unDessert.getNomProduit()+"</td>");
		            System.out.println("</tr>");
		        }
				%>
			</table>
			<img src="../vues/images/desserts.jpg" height="320px" width="480px"
				style="float: right" />
		</div>

		<div id="divBoisson" style="display: none">
			<br>
			<table border="1px"
				style="display: inline-block; vertical-align: top;">
				<tr>
					<th>Boisson</th>
					<th>Volume</th>
				</tr>
				<%
				List<M_Boisson> listBoissons= (List<M_Boisson>)request.getAttribute("listBoissons");
				for (M_Boisson uneBoisson: listBoissons) {
					System.out.println("<tr>");
					System.out.println("<td>"+uneBoisson.getNomProduit()+"</td>");
					System.out.println("<td>"+uneBoisson.getVolume()+" cl</td>");
		            System.out.println("</tr>");
		        }
				%>
			</table>
			<img src="../vues/images/boissons.jpg" height="170px" width="500px"
				style="float: right" />
		</div>

		<script>
		    document.querySelector("#boutonSandwich").onclick = function() {
		        document.querySelector("#divSandwich").style.display = "block";
		        document.querySelector("#divDessert").style.display = "none";
		        document.querySelector("#divBoisson").style.display = "none";
		    }
		    document.querySelector("#boutonDessert").onclick = function() {
		        document.querySelector("#divSandwich").style.display = "none";
		        document.querySelector("#divDessert").style.display = "block";
		        document.querySelector("#divBoisson").style.display = "none";
		    }
		    document.querySelector("#boutonBoisson").onclick = function() {
		        document.querySelector("#divSandwich").style.display = "none";
		        document.querySelector("#divDessert").style.display = "none";
		        document.querySelector("#divBoisson").style.display = "block";
		    }
		</script> 
		</section>
		<footer>
				 <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>