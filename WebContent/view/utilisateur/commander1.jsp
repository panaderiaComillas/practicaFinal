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
			<script type="text/javascript">    
			    function validerChoixSandwichs(name) {
			        numeroBouton = document.getElementByName(name);
			        for (i = 0; i < bouton.length; i++) {
			            if (numeroBouton[i].checked) {
			                return true;
			            }
			        }
			        return false;
			    }
			
			    funtion valeur(){
			        var ok = 1;
			        if (validerChoixSandichs('menus')) {
			            document.getElementById('erreur').style.display = "none";
			        } else {
			            document.getElementById('erreur').style.display = "inline";
			            ok = 0;
			            return false;
			        }
			        if (ok == 1) {
			            document.submit();
			        }
			    }    
			</script>

		<form method="post"
			action="${pageContext.request.contextPath}/C_Commander2">
			<h1 style="color: red;">Ordenar</h1>
			<fieldset>
				<legend>Menu</legend>
				<p>
				Elija su menú :
				<br />
				<br />
				<%
					List<M_Menu> listFormules= (List<M_Menu>)request.getAttribute("listFormules");
					for (M_Menu uneFormule: listFormules) {
						out.println("<input style='float: none ;' type='radio' name='menus' value='menu'"
		                + uneFormule.getIdMenu() + "' id='menu" + uneFormule.getIdMenu()
		                + "'/> <label style='float: none ;' for='menu" + uneFormule.getIdMenu()
		                + "'>" + uneFormule.getNomMenu() + " : " + uneFormule.getPrixMenu()
		                + " €</label>");					
			            out.println("<br/>");
			        }
				%>
				</p>
				<div id="erreur"
					style="text-align: center; color: red; display: none;">
					Veuillez choisir un menu !</div>
				<p style="text-align: center;">
					<input style="float: none; margin-bottom: 0;" type="submit"
						value="Validar" />
				</p>
			</fieldset>
		</form>
		</section>
		<footer> <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>