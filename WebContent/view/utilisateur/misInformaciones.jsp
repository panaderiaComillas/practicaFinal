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
			<form method="post" action=".?controleur=utilisateur&action=modifierCoordonnees">
				<h1 style="color: red;">Datos personales</h1>
				<fieldset>
					<legend>Mis informaciones</legend>
					<label for="nom">Apellido(s) :</label>
					<input type="text" name="nom" id="nom" readonly="readonly" value="admin"></input><br/>
					
					<label for="prenom">Nombre :</label>
					<input type="text" name="prenom" id="prenom" readonly="readonly" value="test"></input><br/>
					
					<label for="mail">E-Mail :</label>
					<input type="text" name="mail" id="mail" readonly="readonly" value="test@test.com"></input><br/>
					
					<label for="tel">Tel :</label>
					<input type="text" name="tel" id="tel" readonly="readonly" value="000000000"></input><br/>
					
					<label for="login">Login :</label>
					<input type="text" name="login" id="login" readonly="readonly" value="admin"></input><br/>
					
					<label for="password">Contraseña :</label>
					<input type="password" name="password" id="password" readonly="readonly" value="password"></input><br/>
	
					<p style="text-align: center;">
						<input style="float: none; margin: 0;" type="submit" value="Editar mis informaciónes" />
					</p>
				</fieldset>
			</form>
		</section>
		<footer> <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>