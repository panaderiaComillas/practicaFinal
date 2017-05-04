<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La Cesta de Pan</title>
</head>
<body>
<%String maVue = (String)request.getAttribute("maVue");%>
	<div id="global">
		<header>
			<%@include file="header.jsp" %>
		</header>
		<nav>
			<%@include file="menu.jsp" %>
		</nav>
		<section>
			<jsp:include page="<%=maVue%>" />
		</section>
		<footer>
			<%@include file="footer.jsp"%>
		</footer>
	</div>
</body>
</html>