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
		<h1 style="color: red;">Pedidos efectuados</h1>
		<table id="tablePedidos">
			<tr>
				<th class="nowrapCell">N° de pedido</th>
				<th class="nowrapCell">Data/hora pedido</th>
				<th class="nowrapCell">Hora de retirada</th>
				<th class="nowrapCell">Tipo de retirada</th>
				<th>Productos</th>
			</tr>
			<tr>
				<td class="nowrapCell">123456</td>
				<td class="nowrapCell">01/03/2017 9h25</td>
				<td class="nowrapCell">11h30</td>
				<td class="nowrapCell">Para llevar</td>
				<td>Tortilla, Coca Cola, Napolitano</td>
			</tr>
			<tr>
				<td class="nowrapCell">789101112</td>
				<td class="nowrapCell">02/03/2017 10h52</td>
				<td class="nowrapCell">12h15</td>
				<td class="nowrapCell">En el sitio</td>
				<td>Pizza, Cerveza, Roscos</td>
			</tr>
		</table>
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