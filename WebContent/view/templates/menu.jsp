<div id="gauche">
	<ul class="menugauche">
		<p>
		<h2>Navegación</h2>
		</p>
		<p class="note">
		<li><a href="${pageContext.request.contextPath}">Página Principal</a></li>
		<hr />
		<%
		if (session.getAttribute("login")!=null) {
            if ((int)session.getAttribute("role") == 1) {
                out.println("<h2>Administrador : <i>"+session.getAttribute("login")+"</i></h2>");
            } else if ((int)session.getAttribute("role") == 2) {
            	out.println("<h2>Cliente : <i>"+session.getAttribute("login")+"</i></h2>");
            } else if ((int)session.getAttribute("role") == 3) {
            	out.println("<h2>Panadero : <i>"+session.getAttribute("login")+"</i></h2>");
            }
        }
		%>
		
		<%
		if ( session.getAttribute("login") != null ) {
			// USERS CONNECTED
			%>
			<li><a href="${pageContext.request.contextPath}/C_Information">Mis Informaciones</a></li>
			<br>
			<%
			if ( (int)session.getAttribute("role") == 1 || (int)session.getAttribute("role") == 2 ) {
				// ADMIN & CLIENT
			%>
			<li><a href="${pageContext.request.contextPath}/C_Commande">Mis Pedidos</a></li>
			<br>
			<% } %>
			<hr/>
			<li><a href="${pageContext.request.contextPath}/C_Formule">Nuestras Fórmulas</a></li>
			<br>
			<li><a href="${pageContext.request.contextPath}/C_Produit">Nuestros Productos</a></li>
			<br>
			<%
			if ( (int)session.getAttribute("role") == 1 || (int)session.getAttribute("role") == 2 ) {
				// ADMIN & CLIENT
			%>
			<li><a href="${pageContext.request.contextPath}/C_Commander1">Ordenar</a></li>
			<% } %>
			
		<% 
		} else { 
			// USERS NO CONNECTED
		%>		
			<li><a href="${pageContext.request.contextPath}/C_Inscription">Registrarse</a></li>
			<br>
			<li><a href="${pageContext.request.contextPath}/C_Connection">Conectarse</a></li>
			<br>
		<% } %>
		
		
		<%
		if ( session.getAttribute("login")!=null && ( (int)session.getAttribute("role") == 1 || (int)session.getAttribute("role") == 3 ) ) {
			// BAKER
        %>
            <hr/>
            <li><a href="">Gérer les formules</a></li><br>
            <!-- AJOUTER / MODIFIER / SUPPRIMER UN FORMULE -->
            <li><a href="">Gérer les produits</a></li><br>
            <!-- AJOUTER / MODIFIER / SUPPRIMER UNE PRODUIT -->
            <li><a href="">Gérer les commandes</a></li><br>
            <!-- AJOUTER / MODIFIER / SUPPRIMER UNE COMMANDE -->
        <%
        }
		if ( session.getAttribute("login")!=null && (int)session.getAttribute("role") == 1 ) {
			// ADMIN
        %>
            <hr>
            <li><a href="">Gérer les utilisateurs</a></li><br>
            <!-- AJOUTER / MODIFIER / SUPPRIMER UNE PERSONNE -->
        <% } %>
        
	</ul>
</div>