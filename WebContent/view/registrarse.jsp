<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La Cesta de Pan</title>
</head>
<body>
	<div id="global">
		<header>
		<div id="entete">
			<h1 id="Titreappli">La Cesta de Pan</h1>
		</div>
		</header>
		<nav>
		<div id="gauche">
			<ul class="menugauche">
				<p>
				<h2>Navegación</h2>
				</p>
				<p class="note">
				<li><a href="/practicaFinal">Página Principal</a></li>
				<hr />
				<li><a href="registrarse.jsp">Registrarse</a></li>
				<br>
				<li><a href="conectarse.jsp">Conectarse</a></li>
				<hr />
				<li><a href="misInformaciones.jsp">Mis Informaciones</a></li>
				<br>
				<li><a href="misPedidos.jsp">Mis Pedidos</a></li>
				<hr />
				<li><a href="formulas.jsp">Nuestras Fórmulas</a></li>
				<br>
				<li><a href="productos.jsp">Nuestros Productos</a></li>
				<hr />
				<li><a href="ordenar.jsp">Ordenar</a></li>
			</ul>
		</div>
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
		<footer>
		<div id="footer">
			<center>
				<p class="footer">
					<b>Autores</b> : <br> <br> 
					RICHARD Antoine - SABARON Benjamin
				</p>
			</center>
		</div>
		</footer>
	</div>
</body>
</html>