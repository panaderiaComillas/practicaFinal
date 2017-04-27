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
		<form method="post" action="${pageContext.request.contextPath}/C_Connection">
			<fieldset>
				<label for="login">Login :</label> 
				<input type="text" name="login" id="login"></input><br /> 
				<label for="mdp">Contraseña :</label> 
				<input type="password" name="mdp" id="mdp"></input><br />
				<p style="text-align: center;">
					<input style="float: none ; margin: 0;" type="submit" value="Validar"></input><br />
				</p>
				<%
				if (request.getAttribute("message")!=null) {
					out.println("<strong>"+request.getAttribute("message")+"</strong>");
				}
				%>
			</fieldset>
		</form>
		</section>
		<footer> <%@include file="/view/templates/footer.jsp"%>
		</footer>
	</div>
</body>
</html>