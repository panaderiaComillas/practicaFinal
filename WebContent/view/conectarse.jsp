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
		<form method="post" action=".?controleur=connexion&action=authentifier">
			<fieldset>
				<label for="login">Login :</label> 
				<input type="text" name="login" id="login"></input><br /> 
				<label for="mdp">Contraseña :</label> 
				<input type="password" name="mdp" id="mdp"></input><br />
				<p style="text-align: center;">
					<input style="float: none ; margin: 0;" type="submit" value="Validar"></input><br />
				</p>
			</fieldset>
		</form>
		</section>
		<footer>
		<div id="footer">
			<center>
				<p class="footer">
					<b>Autores</b> : <br> <br> RICHARD Antoine - SABARON
					Benjamin
				</p>
			</center>
		</div>
		</footer>
	</div>
</body>
</html>