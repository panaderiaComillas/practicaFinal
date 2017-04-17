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
				<li><a href="formulas.jsp">Nuestras Formulas</a></li>
				<br>
				<li><a href="productos.jsp">Nuestros Productos</a></li>
				<hr />
				<li><a href="ordenar.jsp">Ordenar</a></li>
			</ul>
		</div>
		</nav>
		<section>
		<ul id="menu">
			<li class="onglet_1"><a id="boutonSandwich">Sandwichs</a></li>
			<li class="onglet_2"><a id="boutonBoisson">Bebidas</a></li>
			<li class="onglet_3"><a id="boutonDessert">Postre</a></li>
		</ul>

		<div id="divSandwich" style="display: block">
			<br>
			<table border="1px"
				style="display: inline-block; vertical-align: top;">
				<tr>
					<th>Sandwichs</th>
				</tr>
				<tr>
					<td>Panini</td>
				</tr>
				<tr>
					<td>HotDog</td>
				</tr>
			</table>
			<table border="1px"
				style="display: inline-block; vertical-align: top;">
				<tr>
					<th>Ingredientes</th>
				</tr>
				<tr>
					<td>Filete</td>
				</tr>
				<tr>
					<td>Salchicha</td>
				</tr>
			</table>
			<img src="../images/americain.jpg" height="240px" width="360px"
				style="float: right" />
		</div>

		<div id="divDessert" style="display: none">
			<br>
			<table border="1px"
				style="display: inline-block; vertical-align: top;">
				<tr>
					<th>Postre</th>
				</tr>
				<tr>
					<td>Napolitano</td>
				</tr>
				<tr>
					<td>Roscos</td>
				</tr>
			</table>
			<img src="../images/desserts.jpg" height="320px" width="480px"
				style="float: right" />
		</div>

		<div id="divBoisson" style="display: none">
			<br>
			<table border="1px"
				style="display: inline-block; vertical-align: top;">
				<tr>
					<th>Bebidas</th>
					<th>Volumen</th>
				</tr>
				<tr>
					<td>Coca Cola</td>
					<td>33 cl</td>
				</tr>
				<tr>
					<td>Agua</td>
					<td>50 cl</td>
				</tr>
			</table>
			<img src="../images/boissons.jpg" height="170px" width="500px"
				style="float: right" />
		</div>

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
		</section>
		<footer>

		<div id="footer">
			<center>
				<p class="footer">
					<b>Autores</b> : <br> <br> RICHARD Antoine - SABARON Benjamin 
				</p>
			</center>
		</div>
		</footer>
	</div>
</body>
</html>