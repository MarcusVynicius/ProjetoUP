<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Bem vindo !!</title>
<h1 align="center">
	Tela Inicial
</h1>
</head>
<body>
<fieldset style="padding:100px;width:500px;margin:auto;background-color:pink;">
	<a href="cliente.jsp"><p align="center">CLIENTE</p></a>
	</br>
	</br>
	<a href="Pservico.jsp"><p align="center" >PRESTADOR SERVIÇO</p></a>
	<%if(request.getAttribute("cadastro")!=null){ %>
	<p><%out.print(request.getAttribute("cadastro")); %></p>
	<%} %>
</fieldset>
</body>
</html>