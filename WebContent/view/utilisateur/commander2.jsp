<script language="JavaScript" type="text/javascript" src="fonctionsJavascript.inc.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="metier.M_Menu"%>
<%@page import="metier.M_Sauce" %>
<%@page import="metier.M_Ingredient" %>
<%@page import="metier.M_Dessert" %>
<%@page import="metier.M_Boisson" %>
<%@page import="metier.M_TypeRetrait" %>

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
<%
String nomMenu = (String)request.getAttribute("nomMenu");
List<M_Ingredient> listIngredients = (List<M_Ingredient>) request.getAttribute("listIngredients");
List<M_Sauce> listSauces = (List<M_Sauce>) request.getAttribute("listSauces");
List<M_Boisson> listBoissons = (List<M_Boisson>) request.getAttribute("listBoissons");
List<M_Dessert> listDesserts = (List<M_Dessert>) request.getAttribute("listDesserts");
List<M_TypeRetrait> listTypeRetraits = (List<M_TypeRetrait>) request.getAttribute("listTypeRetraits");
%>
<form method="post" action="${pageContext.request.contextPath}/C_Commander3">
	<h1 style="color : red;">Ordenar</h1>
	<fieldset>
		<legend>Menu</legend>
		Elegiste el menu : <% out.println(nomMenu); %>
	    <input type="hidden" name="nomMenu" value="<%=nomMenu%>" id="nomMenu"/>
		<br/><br/>
		<hr><br/>
		Elija sus ingredientes :<br/><br/>
		<%
		for (M_Ingredient unIngredient: listIngredients) {
		%>
			<input style="float: none ; margin-bottom: 0;" type="checkbox" name="ingredients" 
			value="<%=unIngredient.getNomIngredient()%>" id="ingredient<%=unIngredient.getIdIngredient()%>"/>
			<label style="float: none ;" for="ingredient<%=unIngredient.getIdIngredient()%>">
			<%=unIngredient.getNomIngredient()%>
			</label>
			<br/>
	    <% } %>
	
		<br/><br/>
		<hr><br/>
	
		Elija su salsa (varias posibles) :<br/><br/>
		<%
		for (M_Sauce uneSauce: listSauces) {
		%>
			<input style='float: none ; margin-bottom: 0;' type='checkbox' name='sauces'
			value="<%=uneSauce.getNomSauce()%>" id="sauce<%=uneSauce.getIdSauce()%>"/>
			<label style="float: none ;" for="sauce<%=uneSauce.getIdSauce()%>">
			<%=uneSauce.getNomSauce()%>
			</label>
	        <br/>
	    <% } %>
		<br/><hr><br/>
	
		<!-- Menu avec : Boisson ou Dessert -->
		<%
		if (request.getAttribute("nomMenu").toString().lastIndexOf("ou") != -1) {
		%>
			Elija el acompañamiento :<br/><br/>     
			<input style="float: none ; margin-bottom: 0;" type="radio" onclick="BoissonsOU()" name="boud" value="boisson" id="boisson"/>
			<label style="float: none ;" for="boisson">Bebidas</label>
			<br/>
	        <!-- si case boissons coché -->
	        <p id="afficheBoissons" style=" margin: 0; display: none;">
    	    <%
        	for (M_Boisson uneBoisson: listBoissons) {
	        %>
	    		<input style="float: none ; margin-bottom: 0;" type="radio" name="boisson" 
	    		value="<%=uneBoisson.getNomProduit()%>" id="boisson<%=uneBoisson.getIdProduit()%>"/>
    	        <label style="float: none ;" for="boisson<%=uneBoisson.getIdProduit()%>">
        	    <%=uneBoisson.getNomProduit()%>
            	</label>
	        <% } %>
	    	</p>
	        <br/>
    		<input style="float: none ; margin-bottom: 0;" type="radio" onclick="DessertsOU()" name="boud" value="dessert" id="dessert"/>
    		<label style="float: none ;" for="dessert">Postres</label>
    		<br/>
	        <!-- si case desserts coché -->
	        <p id="afficheDesserts" style="margin: 0; display: none;">
	    	<%
    		for (M_Dessert unDessert: listDesserts) {
    		%>
    			<input style="float: none ; margin-bottom: 0;" type="radio" name="dessert" 
	    		value="<%=unDessert.getNomProduit()%>" id="dessert<%=unDessert.getIdProduit()%>"/>
	            <label style="float: none ;" for="dessert<%=unDessert.getIdProduit()%>">
	            <%=unDessert.getNomProduit()%>
    	        </label>
        	<% } %>        
	        </p>
	        <br/>
	    <% } %>
	
		<!-- Menu avec : Boisson + Dessert -->
		<%
		if (request.getAttribute("nomMenu").toString().lastIndexOf("ou") == -1) {
		%>
			Elija los acompañamientos :<br/><br/>    
			Bebidas :
			<%
			for (M_Boisson uneBoisson: listBoissons) {
			%>
	    		<input style="float: none ; margin-bottom: 0;" type="radio" name="boisson" 
	    		value="<%=uneBoisson.getNomProduit()%>" id="boisson<%=uneBoisson.getIdProduit()%>"/>
    	        <label style="float: none ;" for="boisson<%=uneBoisson.getIdProduit()%>">
        	    <%=uneBoisson.getNomProduit()%>
            	</label>
	        <% } %>
	    	<br/><br/>
	    	Postres :
    		<%
    		for (M_Dessert unDessert: listDesserts) {
	    	%>
	    		<input style="float: none ; margin-bottom: 0;" type="radio" name="dessert" 
	    		value="<%=unDessert.getNomProduit()%>" id="dessert<%=unDessert.getIdProduit()%>" />
    	        <label style="float: none ;" for="dessert<%=unDessert.getIdProduit()%>">
        	    <%=unDessert.getNomProduit()%>
            	</label>
		    <%
			}
	    }
    	%>

		<br/><br/><hr><br/>
	
		Elija su tipo y su hora de retirada :<br/><br/>
		<%
		for (M_TypeRetrait unTypeRetrait: listTypeRetraits) {
		%>
			<input style="float: none ; margin-bottom: 0;" type="radio" name="typeRetrait" 
			value="<%=unTypeRetrait.getNomTypeRetrait()%>" id="retrait<%=unTypeRetrait.getIdTypeRetrait()%>"/>
			<label style="float: none ;" for="retrait<%=unTypeRetrait.getIdTypeRetrait()%>">
			<%=unTypeRetrait.getNomTypeRetrait()%>
			</label>
	        <br/>
    	<% } %>
    	<br/>
    	<input type="time" name="heureRetrait" value="11:00:00" max="13:30:00" min="11:00:00" required/>
		<br/>
     
        <p style="text-align: center;">
        	<input style="float: none ; margin-bottom: 0;" type="submit" value="Valider"/>
        	<input style="float: none ; margin-bottom: 0;" type="button" value="Retour" onclick="history.go(-1)">
        </p>
	</fieldset>
</form>
