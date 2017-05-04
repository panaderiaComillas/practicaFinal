<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red;">Ordenar</h1>
<fieldset>
	<legend>Finalización</legend>
	<br />
	<p style="text-align: center; font-size:18px; color:green;">Orden almacenada !
	</p>
	<br/>
	<label>Detalles :</label>
	<br/><br/>
	<p style="text-align: center;">
		Menu : 
		<%
		out.println(request.getAttribute("nomMenu"));

		if(request.getAttribute("ingredients")!=null){
		%>
			<br/><hr>
			Ingredientes : 
			<%
			String[] ingredients = (String[])request.getAttribute("ingredients");
			for (String ingredient : ingredients) {
			%>
				<b><%=ingredient%></b>
		<%	}
		}

		if(request.getAttribute("sauces")!=null){
		%>
			<br/><hr>
			Salsas : 
			<%
				String[] sauces = (String[])request.getAttribute("sauces");
				for (String sauce : sauces) {%>
					<b><%=sauce%></b>
		<%	}
		}

		if(request.getAttribute("boisson")!=null){
		%>
			<br/><hr>
			Bebida : 
			<b><%=request.getAttribute("boisson")%></b>
		<%}
	
		if(request.getAttribute("dessert")!=null){
		%>
			<br/><hr>
			Postre :
			<b><%=request.getAttribute("dessert")%></b>
		<% }

		if(request.getAttribute("typeRetrait")!=null){
		%>
			<br/><hr>
			Retirada :
			<b><%=request.getAttribute("typeRetrait")%></b>
		<% }
		
		if(request.getAttribute("heureRetrait")!=null){
		%>
			<br/><hr>
			Hora de retirada :
			<b><%=request.getAttribute("heureRetrait")%></b>
		<% } %>
	</p>
</fieldset>
