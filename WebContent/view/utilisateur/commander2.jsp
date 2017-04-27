<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="metier.M_Menu"%>
<%@page import="metier.M_Sauce" %>
<%@page import="metier.M_Ingredient" %>
<%@page import="metier.M_Dessert" %>
<%@page import="metier.M_Boisson" %>
<%@page import="metier.M_TypeRetrait" %>
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
			
<script type="text/javascript">
function BoissonsOU() {
        //Boissons OU Desserts
        if (document.getElementById('boisson').checked) {
            document.getElementById('afficheBoissons').style.display="inline";
            
            document.getElementById('afficheDesserts').style.display="none";
        }
}

function DessertsOU() {
        //Boissons OU Desserts
        if (document.getElementById('dessert').checked) {
            document.getElementById('afficheBoissons').style.display="none";
            
            document.getElementById('afficheDesserts').style.display="inline";
        }
}

</script>

<form method="post" action="${pageContext.request.contextPath}/C_Commander3">

    <h1 style="color : red;">Ordenar</h1>
    <fieldset>
    <%
    request.setAttribute("nomMenu", request.getAttribute("nomMenu"));
    
    out.println("<legend>menu</legend>");
    out.println("Elegiste el menu : " + request.getAttribute("nomMenu"));
	out.println("<br/><br/>");
	out.println("<hr><br/>");
	
	out.println("Elija sus ingredientes :<br/><br/>");
	List<M_Ingredient> listIngredients= (List<M_Ingredient>)request.getAttribute("listIngredients");
	for (M_Ingredient unIngredient: listIngredients) {
		out.println("<input style='float: none ; margin-bottom: 0;' type='checkbox' name='ingrédients'" + " value='"+unIngredient.getNomIngredient()+"' id='ingrédient"+unIngredient.getIdIngredient()+"'/> <label style='float: none ;'" + " for='ingrédient"+unIngredient.getIdIngredient()+"'>" + unIngredient.getNomIngredient() + " </label>");
        out.println("<br/>");
    }
	
	out.println("<br/><br/>");
	out.println("<hr><br/>");
	
	out.println("Elija su salsa (varias posibles) :<br/><br/>");
	List<M_Sauce> listSauces= (List<M_Sauce>)request.getAttribute("listSauces");
	for (M_Sauce uneSauce: listSauces) {
		out.println("<input style='float: none ; margin-bottom: 0;' type='checkbox' name='sauces'" + " value='"+uneSauce.getNomSauce()+"' id='sauce"+uneSauce.getIdSauce()+"'/> <label style='float: none ;'" + " for='sauce"+uneSauce.getIdSauce()+"'>" + uneSauce.getNomSauce() + " </label>");
        out.println("<br/>");
    }
	out.println("<br/><hr><br/>");
	
	//Menu avec : Boisson ou Dessert
	if (request.getAttribute("nomMenu").toString().lastIndexOf("ou") != -1) {
		out.println("Elija el acompañamiento :<br/><br/>");      
		out.println("<input style='float: none ; margin-bottom: 0;' type='radio' onclick='BoissonsOU()' name='boud'" + " value='boisson' id='boisson'/> <label style='float: none ;' for='boisson'>Bebidas</label>");
		out.println("<br/>");
        //si case boissons cochÃ©
        out.println("<p id='afficheBoissons' style=' margin: 0; display: none;'>");
        List<M_Boisson> listBoissons= (List<M_Boisson>)request.getAttribute("listBoissons");
    	for (M_Boisson uneBoisson: listBoissons) {
    		out.println("<input style='float: none ; margin-bottom: 0;' type='radio' name='boisson' value='" + uneBoisson.getNomProduit() + "' id='boisson" + uneBoisson.getIdProduit()
            + "'/> <label style='float: none ;' for='boisson" + uneBoisson.getIdProduit() + "'>" + uneBoisson.getNomProduit() + "</label>");
        }
    	out.println("</p>");
        out.println("<br/>");
    	out.println("<input style='float: none ; margin-bottom: 0;' type='radio' onclick='DessertsOU()' name='boud'" + " value='dessert' id='dessert'/> <label style='float: none ;' for='dessert'>Postres</label>");
    	out.println("<br/>");
        // si case desserts cochÃ©
        out.println("<p id='afficheDesserts' style=' margin: 0; display: none;'>");
        List<M_Dessert> listDesserts= (List<M_Dessert>)request.getAttribute("listDesserts");
    	for (M_Dessert unDessert: listDesserts) {
    		out.println("<input style='float: none ; margin-bottom: 0;' type='radio' name='dessert' value='" + unDessert.getNomProduit() + "' id='dessert" + unDessert.getIdProduit()
            + "'/> <label style='float: none ;' for='dessert" + unDessert.getIdProduit() + "'>" + unDessert.getNomProduit() + "</label>");
        }        
        out.println("</p>");
        out.println("<br/>");        
    }
	
	//Menu avec : Boisson + Dessert
	if (request.getAttribute("nomMenu").toString().lastIndexOf("ou") == -1) {
		out.println("Elija los acompañamientos :<br/><br/>");    
		out.println("Bebidas : ");
		List<M_Boisson> listBoissons= (List<M_Boisson>)request.getAttribute("listBoissons");
    	for (M_Boisson uneBoisson: listBoissons) {
    		out.println("<input style='float: none ; margin-bottom: 0;' type='radio' name='boisson' value='" + uneBoisson.getNomProduit() + "' id='boisson" + uneBoisson.getIdProduit()
            + "'/> <label style='float: none ;' for='boisson" + uneBoisson.getIdProduit() + "'>" + uneBoisson.getNomProduit() + "</label>");
        }
    	out.println("<br/><br/>"); 
    	out.println("Postres : ");
    	List<M_Dessert> listDesserts= (List<M_Dessert>)request.getAttribute("listDesserts");
    	for (M_Dessert unDessert: listDesserts) {
    		out.println("<input style='float: none ; margin-bottom: 0;' type='radio' name='dessert' value='" + unDessert.getNomProduit() + "' id='dessert" + unDessert.getIdProduit()
            + "'/> <label style='float: none ;' for='dessert" + unDessert.getIdProduit() + "'>" + unDessert.getNomProduit() + "</label>");
        }       
    }

	out.println("<br/><hr><br/>");
	
	out.println("Elija su tipo de retirada :<br/><br/>");
	List<M_TypeRetrait> listTypeRetraits= (List<M_TypeRetrait>)request.getAttribute("listTypeRetraits");
	for (M_TypeRetrait unTypeRetrait: listTypeRetraits) {
		out.println("<input style='float: none ; margin-bottom: 0;' type='radio' name='typeRetrait'" + " value='"+unTypeRetrait.getNomTypeRetrait()+"' id='retrait"+unTypeRetrait.getIdTypeRetrait()+"'/> <label style='float: none ;'" + " for='retrait"+unTypeRetrait.getIdTypeRetrait()+"'>" + unTypeRetrait.getNomTypeRetrait() + " </label>");
        out.println("<br/>");
    }
	out.println("<br/>");
	
    %> 
        <p style="text-align: center;">
        	<input style="float: none ; margin-bottom: 0;" type="submit" value="Valider"/>
        	<input style="float: none ; margin-bottom: 0;" type="button" value="Retour" onclick="history.go(-1)">
        </p>
        
    </fieldset>
</form>
		</section>
		<footer> <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>