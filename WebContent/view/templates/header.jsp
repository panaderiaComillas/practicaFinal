<div id="entete">
	<h1 id="Titreappli">La Cesta de Pan</h1>

	<%
		if (session.getAttribute("login") != null) {
	%>
	<span class="deconnexion">
		<a href="${pageContext.request.contextPath}/C_Deconnection">
			<img src="./images/exit.png" style="width: 25px; height: 25px;" alt="" />
		</a>
	</span>
	<%
		}
	%>

</div>