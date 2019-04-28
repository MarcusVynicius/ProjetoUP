<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="DAO.DAOServico"%>
<%@page import="model.Servico"%>
<%@page import="java.util.*"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="model.PrestadorServico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	PrestadorServico pres = (PrestadorServico) session.getAttribute("prestador");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<h1>
	Bem vindo! <% out.print(pres.getNome()); %>
	</br>
	Sua Função é <% out.print(request.getAttribute("serv")); %>
</h1>

<body>
	<a href="prestadorAlterar.jsp">Alterar dados</a>
	<br>
	<br>
	<br>
	<a href="prestadorDeletar.jsp">Deletar</a>
	<br>
	<br>
	<br>
	<a href="telaInicial.jsp">Sair</a>
	<br>
	<br>
	<br>
</body>	
</html>