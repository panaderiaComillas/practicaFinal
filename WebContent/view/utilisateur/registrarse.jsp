
<script language="JavaScript" type="text/javascript" src="fonctionsJavascript.inc.js"></script>
<form class="inscription" method="post" action="${pageContext.request.contextPath}/C_InscriptionValider" name="CreateUser">
	<h1 style="color: red;">Registro</h1>
	<fieldset>
		<legend>Mis informaciones generales</legend>
		<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
		%>
		<strong style="color: red;">
			<%
				out.println(error);
			%>
		</strong> <br> <br>
		<%
			}
		%>
		<label for="nom">Apellido(s) :</label>
		<input type="text" name="nom" id="nom"></input><br />
		<label for="prenom">Nombre :</label>
		<input type="text" name="prenom" id="prenom"></input><br />
		<label for="mail">E-Mail :</label> <input type="text" name="mail" id="mail"></input><br />
		<label for="tel">Tel :</label> <input type="text" name="tel" id="tel"></input><br />
	</fieldset>

	<fieldset>
		<legend>Mis identificadores de conexión</legend>
		<label for="login">Login :</label> <input type="text" name="login" id="login"></input><br />
		<label for="mdp">Contraseña :</label>
		<input type="password" name="mdp" id="mdp"></input><br />
		<label for="mdp2">Reescribir la contraseña :</label>
		<input type="password" name="mdp2" id="mdp2"></input><br />
	</fieldset>

	<fieldset style="padding: 1%;">
		<p style="text-align: center; margin: 0;">
			<input style="float: none; margin: 0;" type="submit" value="Validar" onclick="return validerInscription()"></input>
			<input style="float: none; margin: 0;" type="reset" value="Borrar">
	</fieldset>
</form>
