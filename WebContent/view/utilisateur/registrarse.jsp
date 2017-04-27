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
		<form class="inscription" method="post"
			action=".?controleur=utilisateur&action=validationInscription"
			name="CreateUser">
			<h1 style="color: red;">Registro</h1>

			<fieldset>
				<legend>Mis informaciones generales</legend>
				<label for="nom">Apellido(s) :</label>
				<input type="text" name="nom"id="nom"></input><br /> 
				<label for="prenom">Nombre :</label>
				<input type="text" name="prenom" id="prenom"></input><br /> 
				<label for="mail">E-Mail :</label>
				<input type="text" name="mail" id="mail"></input><br /> 
				<label for="tel">Tel :</label> <input type="text" name="tel" id="tel"></input><br />
			</fieldset>

			<fieldset>
				<legend>Mis identificadores de conexión</legend>
				<label for="login">Login :</label>
				<input type="text" name="login"	id="login"></input><br />
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
		</section>
		<footer> <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>