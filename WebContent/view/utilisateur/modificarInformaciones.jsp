
<%@page import="metier.M_User" %>
<% M_User user = (M_User)request.getAttribute("utilisateur"); %>

<form method="post" action="${pageContext.request.contextPath}/C_Information">
	<h1 style="color: red;">Modificación datos personales</h1>
	<fieldset>
		<legend>Mis informaciones</legend>
		<label for="nom">Apellido(s) :</label>
		<input type="text" name="nom" id="nom" value="<%= user.getNomUser() %>"></input><br/>
		
		<label for="prenom">Nombre :</label>
		<input type="text" name="prenom" id="prenom" value="<%= user.getPrenomUser() %>"></input><br/>
		
		<label for="mail">E-Mail :</label>
		<input type="text" name="mail" id="mail" value="<%= user.getEmail() %>"></input><br/>
		
		<label for="tel">Tel :</label>
		<input type="text" name="tel" id="tel" value="<%= user.getTel() %>"></input><br/>
		
		<label for="login">Login :</label>
		<input type="text" name="login" id="login" value="<%= user.getLogin() %>"></input><br/>
		
		<label for="password">Contraseña :</label>
		<input type="password" name="password" id="password"></input><br/>

		<p style="text-align: center; display: inline-block;">
			<input style="float: none ; margin: 0;" type="submit" value="Guardar" name="action"/>
			<input style="float: none ; margin: 0;" type="button" value="Regresar" onclick="history.back()">
		</p>
	</fieldset>
</form>
