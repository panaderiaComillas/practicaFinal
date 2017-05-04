<script language="JavaScript" type="text/javascript" src="fonctionsJavascript.inc.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List" %>
<%@page import="metier.M_Sandwich" %>
<%@page import="metier.M_Ingredient" %>
<%@page import="metier.M_Dessert" %>
<%@page import="metier.M_Boisson" %>

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

<ul id="menu">
	<li class="onglet_1"><a id="boutonSandwich">Bocadillos</a></li>
	<li class="onglet_2"><a id="boutonBoisson">Bebidas</a></li>
	<li class="onglet_3"><a id="boutonDessert">Postres</a></li>
</ul>

<div id="divSandwich" style="display: block">
	<br>
	<table border="1px"
		style="display: inline-block; vertical-align: top;">
		<tr>
			<th>Bocadillos</th>
		</tr>
		<%
		List<M_Sandwich> listSandwichs= (List<M_Sandwich>)request.getAttribute("listSandwichs");
		for (M_Sandwich unSandwich: listSandwichs) {
			out.println("<tr>");
			out.println("<td>"+unSandwich.getNomProduit());
            if(!unSandwich.isTemperaturePain()){
            	out.println(" frío</td>");
            }  
            else if(unSandwich.isTemperaturePain())
            {
            	out.println(" caliente</td>");
            }
            out.println("</tr>");
        }
		%>
	</table>
	<table border="1px"
		style="display: inline-block; vertical-align: top;">
		<tr>
			<th>Ingredientes</th>
		</tr>
		<%
		List<M_Ingredient> listIngredients= (List<M_Ingredient>)request.getAttribute("listIngredients");
		for (M_Ingredient unIngredient: listIngredients) {
			out.println("<tr>");
			out.println("<td>"+unIngredient.getNomIngredient()+"</td>");
            out.println("</tr>");
        }
		%>
	</table>
	<img src="./images/americain.jpg" height="240px" width="360px"
		style="float: right" />
</div>

<div id="divDessert" style="display: none">
	<br>
	<table border="1px"
		style="display: inline-block; vertical-align: top;">
		<tr>
			<th>Postres</th>
		</tr>
		<%
		List<M_Dessert> listDesserts= (List<M_Dessert>)request.getAttribute("listDesserts");
		for (M_Dessert unDessert: listDesserts) {
			out.println("<tr>");
			out.println("<td>"+unDessert.getNomProduit()+"</td>");
            out.println("</tr>");
        }
		%>
	</table>
	<img src="./images/desserts.jpg" height="320px" width="480px"
		style="float: right" />
</div>

<div id="divBoisson" style="display: none">
	<br>
	<table border="1px"
		style="display: inline-block; vertical-align: top;">
		<tr>
			<th>Bebida</th>
			<th>Cantidad</th>
		</tr>
		<%
		List<M_Boisson> listBoissons= (List<M_Boisson>)request.getAttribute("listBoissons");
		for (M_Boisson uneBoisson: listBoissons) {
			out.println("<tr>");
			out.println("<td>"+uneBoisson.getNomProduit()+"</td>");
			out.println("<td>"+uneBoisson.getVolume()+" cl</td>");
            out.println("</tr>");
        }
		%>
	</table>
	<img src="./images/boissons.jpg" height="170px" width="500px"
		style="float: right" />
</div>
