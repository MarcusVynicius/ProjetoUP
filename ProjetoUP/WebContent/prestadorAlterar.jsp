<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.PrestadorServico"%>
<%
	PrestadorServico pres = (PrestadorServico) session.getAttribute("prestador");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="servletPSAlt" method="post">
		<input type="text" value="<%out.print(pres.getNome());%>"> 
		</br>		
		<input type="text" value="<%out.print(pres.getEmail());%>">
		</br>
		<input type="text" value="<%out.print(pres.getEndereco());%>"> 
		</br> 
		<input type="text" value="<%out.print(pres.getTelefone());%>"> 
		</br> 
		<input type="text" value="<%out.print(pres.getSenha());%>">
		</br> 
		<input type="submit" value="alterar">
	</form>

</body>
</html>