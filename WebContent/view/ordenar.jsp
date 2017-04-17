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
			action=".?controleur=utilisateur&action=commander2">
			<h1 style="color: red;">Hacer un pedido</h1>
			<fieldset>
				<legend>Fórmulas</legend>
				<p>
					Escoja su fórmula: <br />
					<br />
					<input style="float: none ;" type="radio" name="menus" value="menu1" id="menu1"/>
                	<label style="float: none ;" for="menu1">Básica : 5 €</label>
                	<br/>
                	<input style="float: none ;" type="radio" name="menus" value="menu2" id="menu2"/>
                	<label style="float: none ;" for="menu2">Familiar : 8.90 €</label>
                	<br/>
                	<input style="float: none ;" type="radio" name="menus" value="menu3" id="menu3"/>
                	<label style="float: none ;" for="menu3">Gastrónomica : 12 €</label>
                	<br/>
				</p>
				<div id="erreur" style="text-align: center; color: red; display: none;">
				¡ Por favor, escoja una fórmula !
				</div>
				<p style="text-align: center;">
					<input style="float: none; margin-bottom: 0;" type="submit" value="Valider" />
				</p>
			</fieldset>
		</form>
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