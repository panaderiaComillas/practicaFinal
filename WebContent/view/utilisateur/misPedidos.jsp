<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List" %>
<%@page import="metier.M_Commande" %>
<%@page import="dao.M_DaoProduit" %>
<%@page import="metier.M_Produit" %>

<h1 style="color: red;">Pedidos efectuados</h1>
<table cellspacing="10" id="tablePedidos" style="text-align:center;">
	<tr>
		<th class="nowrapCell">N° de pedido</th>
		<th class="nowrapCell">Data/hora pedido</th>
		<th class="nowrapCell">Hora de retirada</th>
		<th class="nowrapCell">Tipo de retirada</th>
		<th>Productos</th>
	</tr>
	
	<%
	List<M_Commande> listCommandes= (List<M_Commande>)request.getAttribute("listCommandes");
	for (M_Commande uneCommande: listCommandes) {
		out.println("<tr>");
		out.println("<td class=\"nowrapCell\">"+uneCommande.getIdCommande()+"</td>");
		out.println("<td class=\"nowrapCell\">"+uneCommande.getDateHeure()+"</td>");
		out.println("<td class=\"nowrapCell\">"+uneCommande.getHeureRetrait()+"</td>");
		out.println("<td class=\"nowrapCell\">"+uneCommande.getTypeRetrait().getNomTypeRetrait()+"</td>");
        out.println("<td>");
        M_DaoProduit daoProduit = new M_DaoProduit();
        List<M_Produit> listProduits = daoProduit.getProduitsCommandeByIdCommande(uneCommande.getIdCommande());
        for (M_Produit unProduit: listProduits) {
        	out.println(unProduit.getNomProduit()+", ");
        }
        out.println("</td>");
        out.println("</tr>");
	}
    %>
</table>
